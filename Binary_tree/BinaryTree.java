public class BinaryTree<T> implements Set<T> {
	
	//nested class, representing an node.
	public static class Node<T> {
		public Node left = null;
		public Node right = null;
		T data;
	}

	public boolean add(T data) {
		return true;
	}

	public boolean remove(T data) {
		return true;
	}
}