Uppgifter...


Ange ordningen som hörnen besöks vid en djupetförstsökning (DFS) med start i hörn 0.:

0 -> 1 -> 4 -> 3 -> 5;
0 -> 3;
2;
6 -> 7;

Ange ordningen som hörnen besöks vid en breddenförstsökning (BFS) med start i hörn 0.:

0 -> 1; 0-> 3;
2;
1 -> 4; 3 -> 5;
6 -> 7;


Skulle du representera en graf med hjälp av en närhetsmatris eller med hjälp av närhetslistor i följande fall? Motivera dina svar.

* Grafen har 1000 hörn och 2000 kanter och det är viktigt att vara sparsam med minnet.:

Närhetslista. Snabb överslagsräkning. 1000^2 eller 2000 antal element.

* Grafen har 1000 hörn och 50000 kanter och det är viktigt att vara sparsam med minnet.:

Närhetslista. Snabb överslagsräkning 1000^2 eller 50000 antal element.

*Det är viktigt att snabbt (på konstant tid) kunna avgöra om två hörn är grannar. Om möjligt vill du också vara sparsam med minnet.

Närhetsmatris.

* Förklara varför DFS tar Θ(n^2) tid för en sammanhängande graf med n hörn om grafen representeras med en närhetsmatris.

Matris innebär en tvådimensionell array. Lite förenklat kommer den behöva läsa alla element i arrayen och komplexiteten blir därför O(n^2)


Exempelkörning:

Time: 1417000 maximum component size: 4 Size: 10 matrix
Time: 1337000 maximum component size: 4 Size: 10 graph
Time: 524000 maximum component size: 15 Size: 100 matrix
Time: 397000 maximum component size: 15 Size: 100 graph
Time: 9421000 maximum component size: 153 Size: 1000 matrix
Time: 2398000 maximum component size: 153 Size: 1000 graph
Time: 31916000 maximum component size: 282 Size: 5000 matrix
Time: 2235000 maximum component size: 548 Size: 5000 graph


Tid anges i ns.

DFS:

lista -> O(n)
Matris -> O(n^2)