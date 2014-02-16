public class BinaryTree<T extends Comparable<T>> implements Set<T> {

	//fields
	private int size; //0
	private int leafs; //0
	private int height; //0
	private Node<T> root; //null


	public static class NoRootException extends IllegalArgumentException{
		public NoRootException(){
			super("Root is not set");
		}
	}

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
	}

	public BinaryTree() {
		//do nothing
	}

	//TODO fix current.parent bug!

	/**
	* @return true if insertion was succeded.
	* @param data is the element which you want to insert.
	*/

	public boolean add(T data) {
		//null is not accepted
		if (data == null) {
			throw new IllegalArgumentException();
		}

		Node<T> newNode = new Node<T>(data);
		//tree is empty, create a root.
		if (this.root == null) {
			this.size +=1;
			this.root = newNode;
			return true;
		}
		Node<T> current = this.root;
		//a parent for our future node.
		Node<T> parent; //null
		//keep going until something happens.
		while(true) {
			parent = current;
			//data > curren.data
			if (data.compareTo(current.data) > 0) {
				current = current.left;
				//if left is null
				if (current == null) {
					parent.left = newNode;
					this.size +=1;
					return true;
				}
			}else if (data.compareTo(current.data) < 0) {
					current = current.right;
					//if right is null
					if (current == null) {
						parent.right = newNode;
						this.size +=1;
						return true;
					}
			} else {
					return false;
			}
		}
	}

	public boolean contains(T data) {
		//null is not accepted
		if (data == null) {
			throw new IllegalArgumentException();
		}

		if (this.root == null) {
			throw new NoRootException();
		}
		//set current node
		Node<T> current = this.root;
		while(true) {
			//match!
			if (data.compareTo(current.data) == 0) {
				return true;
			}

			if (data.compareTo(current.data) > 0) {
				current = current.left;
				if (current == null) {	
					return false;
				}
			}
			if (data.compareTo(current.data) < 0) {
				current = current.right;
				if (current == null) {
					return false;
				}
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
