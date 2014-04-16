import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphMain {

private static final int[] n = {10,100,1000,5000};
private static final int numberOfTests = n.length;
private static Random randomNumber = new Random(System.nanoTime());
private static int counter = 0;

	public static void main(String[] args) {

		for (int i = 0; i < numberOfTests ; i++) {
			int size = n[i];
			String method;
			int numberOfComponents = 0;
			final AtomicInteger maxValue = new AtomicInteger(Integer.MIN_VALUE);
			Graph matrix = setupMatrixGraph(size);
			Graph hash = setupHashGraph(size);
			Graph[] graphs = {matrix, hash};
			for (Graph graph : graphs) {

				counter++;
				if (counter % 2 == 0) {
					method = "graph";
				}else {
					method = "matrix";
				}

				final AtomicInteger componentSize = new AtomicInteger();
				long startTime = System.nanoTime();
				boolean[] visited = new boolean[size];
				for(int v = 0; v < size; v++) {
					if(visited[v] == false) {
						numberOfComponents++;
						componentSize.set(0);
					}
					GraphAlgorithms.dfs(graph, v, visited, new VertexAction() {
						@Override
						public void act(Graph g, int w) {
							int size = componentSize.incrementAndGet();
							if(size > maxValue.intValue()) {
								maxValue.set(size);
							}
						}
					});
				}
				long endTime = System.nanoTime();
				long end = endTime - startTime;
				System.out.print("Time: " + end);
				System.out.println(" maximum component size: " + maxValue + " Size: " + size + " " + method);
			}
		}
	}

	public static Graph setupMatrixGraph(int size) {
		Graph graph = new MatrixGraph(size);
		addNodes(graph, size);
		return graph;
	}

	public static Graph setupHashGraph(int size) {
		Graph graph = new HashGraph(size);
		addNodes(graph, size);
		return graph;
	}

	public static void addNodes(Graph graph, int size) {
		for(int i = 0; i < size;) {
			int a = randomNumber.nextInt(size);
			int b = randomNumber.nextInt(size);
			if(!graph.hasEdge(a,b)) {
				graph.add(a,b);
				i++;
			}
		}
	}
}