%%
%% This is the lexicon part of the natural language processor
%%

article(a).  article(the).  

common_noun(park,X) :- park(X).  
common_noun(tree,X) :- tree(X).
common_noun(hat,X) :- hat(X).  
common_noun(man,X) :- person(X), sex(X,male). 
common_noun(woman,X) :- person(X), sex(X,female). 

adjective(big,X) :- size(X,big).    
adjective(small,X) :- size(X,small). 
adjective(red,X) :- color(X,red).  
adjective(blue,X) :- color(X,blue). 

preposition(on,X,Y) :- on(X,Y).     
preposition(in,X,Y) :- in(X,Y). 
preposition(beside,X,Y) :- beside(X,Y). 
% The preposition 'with' is flexible in how it is used.
preposition(with,X,Y) :- on(Y,X).        % Y can be on X
preposition(with,X,Y) :- in(Y,X).        % Y can be in X
preposition(with,X,Y) :- beside(Y,X).    % Y can be beside X

% Any word that is not in one of the four categories above.
proper_noun(X,X) :- \+ article(X), \+ adjective(X,_), 
                    \+ common_noun(X,_), \+ preposition(X,_,_).

%%
%% This is the world database part of the natural language processor
%%

person(john). person(george). person(mary). person(linda).  
park(kew_beach). park(queens_park). 
tree(tree01). tree(tree02).  tree(tree03).  
hat(hat01).   hat(hat02).  hat(hat03).  hat(hat04).

sex(john,male).    sex(george,male). 
sex(mary,female).  sex(linda,female).

color(hat01,red).   color(hat02,blue). 
color(hat03,red).   color(hat04,blue).  

in(john,kew_beach).     in(george,kew_beach). 
in(linda,queens_park).  in(mary,queens_park).  
in(tree01,queens_park). in(tree02,queens_park). 
in(tree03,kew_beach).

beside(mary,linda). beside(linda,mary). 

on(hat01,john). on(hat02,mary). on(hat03,linda). on(hat04,george). 

size(john,small).    size(george,big). 
size(mary,small).    size(linda,small). 
size(hat01,small).   size(hat02,small). 
size(hat03,big).     size(hat04,big).  
size(tree01,big).    size(tree02,small).  size(tree03,small). 

%%
%% This is the parser part of the natural language processor
%%

np([Name],X) :- proper_noun(Name,X).
np([Art|Rest],X) :- article(Art), np2(Rest,X).

np2([Adj|Rest],X) :- adjective(Adj,X), np2(Rest,X). 
np2([Noun|Rest],X) :- common_noun(Noun,X), mods(Rest,X). 

mods([],_). 
mods(Words,X) :- 
   append(Start,End,Words),   % Break the words into two pieces.
   pp(Start,X),               % The first part is a PP.
   mods(End,X).               % The last part is a Mods again.

pp([Prep|Rest],X) :- preposition(Prep,X,Y), np(Rest,Y).

%%
%% This is the part of the natural language processor that can answer
%%    yes/no questions
%%

yes_no(String) :- 
   split_words(String,Words),  % Get the list of words.
   yn(Words).                  % Use yn on the words.

yn([Verb|Rest]) :-
   Verb=is,                    % The first word must be "is".
   append(W1,W2,Rest),         % Break the rest into two parts.
   np(W1,Ref),                 % The first part must be an NP.
   np_or_pp(W2,Ref).           % The second part must be an NP or a PP.

np_or_pp(W,Ref) :- np(W,Ref).
np_or_pp(W,Ref) :- pp(W,Ref).

%%
%% This is the wordUtils package from Appendix A
%%

% this predicate breaks up a quoted string into a list of constants
split_words(String,Words) :- 
   atom_codes(String,List), scan_codes(List,[],[],Words).
    
scan_codes([],RevChars,RevWords,F) :- 
   add_word(RevChars,RevWords,New), reverse(New,F).
scan_codes([Char|Chars],RevChars,RevWords,F) :- 
   blank(Char), add_word(RevChars,RevWords,New),
   scan_codes(Chars,[],New,F).
scan_codes([Char|Chars],RevChars,RevWords,F) :- 
   punc(Char,Name), add_word(RevChars,RevWords,New),
   scan_codes(Chars,[],[Name|New],F).
scan_codes([Char|Chars],RevChars,RevWords,F) :- 
   alpha(Char), 
   scan_codes(Chars,[Char|RevChars],RevWords,F).

add_word([],Old,Old).
add_word(RevChars,Old,[Word|Old]) :- 
  \+ RevChars=[], reverse(RevChars,Chars), atom_codes(Word,Chars). 

blank(32). 
punc(44,'*comma*'). 
punc(46,'*period*'). 
punc(63,'*question*'). 
punc(33,'*exclamation*'). 
punc(58,'*colon*'). 
punc(59,'*semicolon*'). 
alpha(Char) :- 65 =< Char, Char =< 90.
alpha(Char) :- 97 =< Char, Char =< 122.

% These predicates deal with the case of a word

upcase(Lower,Upper) :- 
  atom_codes(Lower,[Lo|L]), Hi is Lo-32, atom_codes(Upper,[Hi|L]).
downcase(Upper,Lower) :- 
  atom_codes(Upper,[Hi|L]), Lo is Hi+32, atom_codes(Lower,[Lo|L]).

% This one ensures the word is in lowercase 
lower_case(Word,Word) :- 
  atom_codes(Word,[Ch|_]), 97 =< Ch, Ch =< 122.
lower_case(Word,Lower) :- 
  atom_codes(Word,[Ch|_]), 65 =< Ch, Ch =< 90, downcase(Word,Lower).

% This pair adds or removes a trailing 's' from a word
add_s(Sing,Plur) :-  atom_codes(s,[S]),
  atom_codes(Sing,L), reverse(L,L1), 
  reverse([S|L1],L2), atom_codes(Plur,L2).
rem_s(Plur,Sing) :-  atom_codes(s,[S]),
  atom_codes(Plur,L), reverse(L,[S|L1]), 
  reverse(L1,L2), atom_codes(Sing,L2).
