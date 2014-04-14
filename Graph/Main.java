public class Main {
	public static void main(String[] args) {
		HashGraph graph = new HashGraph(4);

		graph.addBi(0,1,5);
		System.out.println(graph.cost(0,1));
		graph.removeBi(0,1);
		System.out.println(graph.cost(0,1));
		System.out.println(graph.cost(10,3));
		// for(int i = 0;i<=1;i++) {
		// 	System.out.print("Node number: " + Integer.toString(i) + " ");
		// 	System.out.println(graph.cost())
		// 	// System.out.println(graph.cost(1,i));
		// 	// System.out.println(graph.degree(i));
		// }
	}
}