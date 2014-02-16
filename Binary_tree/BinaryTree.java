public class BinaryTree<T extends Comparable<T>> implements Set<T> {

	//fields
	private int size; //0
	private int leafs; //0
	private int height; //0
	private Node<T> root; //null

	//nested class, representing an node.

	// **/
	// * in C:
	// *	struct node {
	// *		node *left;
	// *		node *right;
	// *		void *data;
	// *	}
	// *
	// */
	public static class Node<T extends Comparable<T>> {
		public Node<T> left; //null
		public Node<T> right; //null
		public Node<T> parent; //null
		private T data;
		//create new node
		public Node(T data) {
			this.data = data;
		}
		public Node(T data,Node<T> parent) {
			this.data = data;
			this.parent = parent;
		}
	}

	public BinaryTree() {
		//do nothing
	}

	public boolean add(T data) {
		Node<T> newNode = new Node<T>(data);
		//tree is empty, create a root.
		if (this.root == null) {
			this.size +=1;
			this.root = newNode;
			return true;
		}

			Node<T> current = this.root;
			//a parent for our future node.
			Node<T> parent;
			//keep going until something happens.
			while(true) {
				parent = current;
				//data > curren.data
				if (data.compareTo(current.data) > 0) {
					current = current.left;
					//if left is null
					if (current == null) {
						parent.left = newNode;
						//we're ok.
						this.size +=1;
						return true;
					}
					//data < current.data
					}else if (data.compareTo(current.data) < 0) {
						current = current.right;
						//if right is null
						if (current == null) {
							parent.right = newNode;
							this.size +=1;
							return true;
						}
					//data = current.data
					} else {
						return false;
					}
				}
			}

	//remove node from tree.
	public boolean remove(T data) {
		//TODO
		return true;
	}

	//returns number of elements in tree.
	public int numberOfElements() {
		return this.size;
	}

	//returns the give height of the tree.
	public int height() {
		return this.height;
	}

	//returns the number of leafs in tree.
	public int numberOfLeafs() {
		return this.leafs;
	}

	//implement BFS algorithm
	public String toString() {
		return "";
	}
}

