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
			//TODO
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
		} else {
				//it's dangerous to go alone. Take this!
				Node<T> current = this.root;
				//a parent for our future node.
				Node<T> parent;
				while(true) {
					parent = current;
					//true
					if (data.compareTo(current.data) > 0) {
						current = current.left;
						if (current == null) {
							parent.left = newNode;
							//we're ok.
							return;
						}
					}
				}
			}
		}

	// public boolean add(T data) {
	// 	if(addElement(data,this.root)) {
	// 		return true;
	// 	}else {
	// 		return false;
	// 	}
	// }

	private boolean addElement(T data,Node<T> node) {
		//no root node. Tree will be created.
		if (node == null) {
			//create new node!
			node = new Node<T>(data);
			this.size +=1;
			this.leafs +=1;
			//everything is ok!
			//node.parent = null;
			return true;
		}

		//this should not happen
		if (data.compareTo(node.data) == 0) {
			System.out.println("same data");
			return false;
		}

		//if data.compareTo is true
		if (data.compareTo(node.data) > 0) {
			addToLeft(node,data);
			return true;
		}

		//if data.compareTo is false
		if (data.compareTo(node.data) < 0) {
			addToRight(node,data);
			return true;
		}
		//if everything else fails.
		return false;
	}

	//add node right to parent.
	private void addToRight(Node<T> node,T data) {
		//it's empty on the right side, create new node.
		if (node.right == null) {
		this.size +=1;
		node.right = new Node<T>(data, node);
		}
	}

	//add node left to parent.
	private void addToLeft(Node<T> node,T data) {
		//it's empty on the left side, create new node.
		if (node.left == null) {
		this.size +=1;
		node.left = new Node<T>(data,node);
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

