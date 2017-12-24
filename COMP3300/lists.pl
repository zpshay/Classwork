on(Item, [Item|Rest]).
on(Item, [Head|Tail]) :- on(Item, Tail).
