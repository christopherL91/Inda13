public class Main {
	public static void main(String[] args) {
		HashGraph graph = new HashGraph(5);
		graph.addBi(0, 1);
		graph.add(2, 3, 1);
		System.out.println(graph);
		// for(int i = 0;i<=1;i++) {
		// 	System.out.print("Node number: " + Integer.toString(i) + " ");
		// 	System.out.println(graph.cost())
		// 	// System.out.println(graph.cost(1,i));
		// 	// System.out.println(graph.degree(i));
		// }
	}
}