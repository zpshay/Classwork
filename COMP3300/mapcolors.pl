solution(A,B,C,D,E,F,G) :- color(A), color(B), color(C), color(D), color(E), color(F), color(G), \+ A=B, \+ A=D, \+ A=E, \+ A=G, \+ B=C, \+ B=D, \+ C=D, \+ D=E, \+ D=F, \+ E=F, \+ E=G, \+ F=G.

color(yellow).
color(orange).
color(red). 