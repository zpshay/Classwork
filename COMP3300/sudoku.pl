sudoku(R11,R12,R13,R14,R21,R22,R23,R24,R31,R32,R33,R34,
R41,R42,R43,R44) :-
solution(R11,R12,R13,R14,R21,R22,R23,R24,R31,R32,R33,R34,
R41,R42,R43,R44),
nl, write(’A solution to this puzzle is’), nl,
printrow(R11,R12,R13,R14), printrow(R21,R22,R23,R24),
printrow(R31,R32,R33,R34), printrow(R41,R42,R43,R44).
% Print a row of four numbers with spaces between them.
printrow(P,Q,R,S) :- write(’ ’), write(P), write(’ ’), write(Q),
write(’ ’), write(R), write(’ ’), write(S), nl.
%------------------------------------------------------------------
solution(R11,R12,R13,R14,R21,R22,R23,R24,R31,R32,R33,R34,
R41,R42,R43,R44) :-
uniq(R11,R12,R13,R14), uniq(R21,R22,R23,R24), % rows 1,2
uniq(R31,R32,R33,R34), uniq(R41,R42,R43,R44), % rows 3,4
uniq(R11,R21,R31,R41), uniq(R12,R22,R32,R42), % cols 1,2
uniq(R13,R23,R33,R43), uniq(R14,R24,R34,R44), % cols 3,4
uniq(R11,R12,R21,R22), uniq(R13,R14,R23,R24), % NW and NE
uniq(R31,R32,R41,R42), uniq(R33,R34,R43,R44). % SW and SE
% uniq holds if P,Q,R,S are all distinct nums (from 1 to 4).
uniq(P,Q,R,S) :- num(P), num(Q), num(R), num(S),
\+ P=Q, \+ P=R, \+ P=S, \+ Q=R, \+ Q=S, \+ R=S.
% The four numbers to go into each cell
num(1). num(2). num(3). num(4).