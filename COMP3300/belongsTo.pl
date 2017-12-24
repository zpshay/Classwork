belongsTo(Item, [Item|Rest]).
belongsTo(Item, [Head|Tail]) :- belongsTo(Item, Tail).
