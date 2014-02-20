#Veckans uppgifter:

add(T data) -> Medel: O(log(n)), Värsta: O(n) vilket sker då många element samlas på en och samma sida.

contains(T data) -> Medel och värsta: O(n) då den besöker alla noder en gång.

numberOfElements() -> O(1) 

height(Node<T> node) -> O(n)

getNumberOfLeafs() -> O(n)

toString() -> O(n) eftersom att varje nod besöks 1 gång.

#Treap:
Tidskomplexiteten blir O(log(n)) eftersom att trädet behålls balanserat hela tiden. Vilket gör att höjden i trädet är log(n) hela tiden. Man undviker alltså de fallgropar som annars finns, då trädet kan bli en länkad lista och få tidskomplexiteten O(n) istället.
