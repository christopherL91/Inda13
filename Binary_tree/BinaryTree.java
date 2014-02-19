/**
* @author Christopher Lillthors
* @version 2.0
*/

public class BinaryTree<T extends Comparable<T>> implements Set<T> {

	//private fields.
	private int size; //0
	private int leafs; //0
	private int height; //0
	private Node<T> root; //null

	/* -------------------------------------------*/
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
	/* ---------------------------------------------*/

	public static class Node<T extends Comparable<T>> {
		//reference to left
		public Node<T> left; //null
		//reference to right
		public Node<T> right; //null
		//holds the data
		private T data;
		//create new node
		/**
		* @param data, element in node
		* @return Node object
		*/
		public Node(T data) {
			this.data = data;
		}
	}

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
		Node<T> parent;
		//keep going until something happens.
		while(true) {
			parent = current;
			if (data.compareTo(current.data) < 0) {
				current = current.left;
				//if left is null
				if (current == null) {
					parent.left = newNode;
					this.size +=1;
					return true;
				}
			}else if (data.compareTo(current.data) > 0) {
					current = current.right;
					//if right is null
					if (current == null) {
						parent.right = newNode;
						this.size +=1;
						return true;
					}
			//same data. Return false
			} else if (data.compareTo(current.data) == 0) {
					return false;
			}
		}
	}

	/**
	* @param data, data to search for in tree
	* @return true/false depending on if the method finds the node with
	* the right data
	*/
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

	/**
	* @return returns number of elements in tree
	*/
	public int numberOfElements() {
		return this.size;
	}
	/**
	* @return returns the height of the tree
	*/
	public int getHeight() {
		int tmp = height(this.root);
		return tmp;
	}

	//returns the give height of the tree.
	private int height(Node<T> node) {
		if (node == null) {
			return 0;
		}else {
			return 1 + Math.max(height(node.left),
								height(node.right));
		}
	}

	/**
	* @return returns the number of leafs in tree
	*/
	public int getNumberOfLeafs() {
		int tmp = leafs(this.root);
		return tmp;
	}

	//returns the number of leafs in tree.
	private int leafs(Node<T> node) {
		if (node == null) {
			return 0;
		}else if( node.left == null && node.right == null){
			return 1;
		}else {
			return leafs(node.left) + leafs(node.right);
		}
	}

	/**
	* @return returns a string consisting if all the elements in the tree.
	*/
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		stringHelper(this.root,string);
		string.append("]");
		return string.toString();
	}

	//time complexity is O(n) since the algorithm visits every node just once
	private void stringHelper(Node<T> node, StringBuilder string) {
		//empty tree
		if (node == null) {
			return;
		}

		if (node.left != null) {
			stringHelper(node.left,string);
			string.append(",");
		}

		//append data to string
		string.append(node.data);

		if (node.right != null) {
			string.append(",");
			stringHelper(node.right,string);
		}
	}
}

