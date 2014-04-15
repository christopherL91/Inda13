import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author Christopher Lillthors
 * @version 1.0 BETA
 */
public class HashGraph implements Graph {
	/**
	 * The map edges[v] contains the key-value pair (w, c) if there is an edge
	 * from v to w; c is the cost assigned to this edge. The maps may be null
	 * and are allocated only when needed.
	 */
	private final Map<Integer, Integer>[] edges;
	private final static int INITIAL_MAP_SIZE = 4;

	/** Number of edges in the graph. */
	private int numEdges;

	/**
	 * Constructs a HashGraph with n vertices and no edges. Time complexity:
	 * O(n)
	 *
	 * @throws IllegalArgumentException
	 *             if n < 0
	 */
	public HashGraph(int n) {
		if (n < 0)
			throw new IllegalArgumentException("n = " + n);

		// The array will contain only Map<Integer, Integer> instances created
		// in addEdge(). This is sufficient to ensure type safety.
		@SuppressWarnings("unchecked")
		Map<Integer, Integer>[] a = new HashMap[n];
		edges = a;
	}

	/**
	 * Add an edge without checking parameters.
	 */
	private void addEdge(int from, int to, int cost) {
		if (edges[from] == null)
			edges[from] = new HashMap<Integer, Integer>(INITIAL_MAP_SIZE);
		if (edges[from].put(to, cost) == null)
			numEdges++;
	}

	@Override
	//getter for edges.lenght
	public int numVertices() {
		return this.edges.length;
	}

	@Override
	//getter for numEdges;
	public int numEdges() {
		return this.numEdges;
	}

	@Override
	public int degree(int v) throws IllegalArgumentException {
		if (v < 0) {
			throw new IllegalArgumentException("v is to small");
		}
		if (v >= edges.length) {
			throw new IllegalArgumentException("v is to large");
		}
		Map<Integer,Integer> tmp = edges[v];
		if (!isEmpty(tmp)) {
			return tmp.size();
		}
		return 0;
	}

	//------------------------------------------------
	//Utilities.
	private void checkRange(int v, int w, int c) throws IllegalArgumentException {
		checkRange(v,w);
		if(c < 0 ) {
			throw new IllegalArgumentException("cost is to small");
		}
	}

	private void checkRange(int v,int w) throws IllegalArgumentException {
		if (v > numVertices() || w > numVertices()) {
			throw new IllegalArgumentException("To many vertices");
		}

		if (v < 0 || w < 0) {
			throw new IllegalArgumentException("To small");
		}
	}

	private boolean isEmpty(Map<Integer,Integer> tmp) {
		if (tmp == null) {
			return true;
		}
		if(tmp.size() == 0) {
			return true;
		}
		return false;
	}

	//------------------------------------------------

	@Override
	public VertexIterator neighbors(int v) {

		//check for errors.
		final Map<Integer,Integer> map = edges[v];

		if(map == null) {
			return new VertexIterator() {
				@Override
				public boolean hasNext() {
					return false;
				}
				@Override
				public int next() throws NoSuchElementException {
					throw new NoSuchElementException();
				}
			};
		}

		final Iterator<Map.Entry<Integer,Integer>> tmp = map.entrySet().iterator();

		return new VertexIterator() {

			@Override
			public boolean hasNext() {
				return tmp.hasNext();
			}

			@Override
			public int next() throws NoSuchElementException {
				if(tmp.hasNext()) {
					Map.Entry<Integer,Integer> entry = tmp.next();
					return entry.getKey();
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}

	@Override
	public boolean hasEdge(int v, int w) throws IllegalArgumentException {
		checkRange(v,w);
		Map<Integer,Integer> tmp = edges[v];
		if (!isEmpty(tmp) && tmp.containsKey(w)) {
				return true;
			}
		return false;
	}

	@Override
	public int cost(int v, int w) throws IllegalArgumentException {
		checkRange(v,w);
		Map<Integer,Integer> tmp = edges[v];
		if (!isEmpty(tmp) && tmp.containsKey(w)) {
			return tmp.get(w);
		}
		return NO_COST;
	}

	@Override
	public void add(int from, int to) {
		checkRange(from,to);
		addEdge(from,to,-1);
	}


	@Override
	public void add(int from, int to, int c) {
		checkRange(from,to,c);
		addEdge(from,to,c);
	}

	@Override
	public void addBi(int v, int w) {
		checkRange(v,w);
		addEdge(v,w,-1);
		addEdge(w,v,-1);
		// this.numEdges--; //fur da lulz...
	}

	@Override
	public void addBi(int v, int w, int c) {
		checkRange(v,w,c);
		addEdge(v,w,c);
		addEdge(w,v,c);
	}

	@Override
	public void remove(int from, int to) {
		checkRange(from,to);
		Map<Integer,Integer> tmp = edges[from];
		if (!isEmpty(tmp) && tmp.containsKey(to)) {
			tmp.remove(to);
			this.numEdges--;
		}
	}

	@Override
	public void removeBi(int v, int w) {
		checkRange(v,w);
		remove(v,w);
		remove(w,v);
	}

	/**
	 * Returns a string representation of this graph.
	 *
	 * @return a String representation of this graph
	 */
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		Map<Integer,Integer> tmp;
		out.append("{");
		for(int i  = 0; i < edges.length; i++) {
			tmp = edges[i];
			if (tmp == null) {
				continue;
			}
			for(Map.Entry entry : tmp.entrySet()) {
					if ((int)entry.getValue() == -1) {
					out.append("(" + i + "," + entry.getKey() + ")" + ",");
				} else{
					out.append("(" + i + "," + entry.getKey() + "," + entry.getValue() + ")" + ",");
				}
			}
		}
		if (out.length() > 2) {
		out.setLength(out.length() - 2);
		out.append(")");
		}

		out.append("}");
		return out.toString();
	}
}