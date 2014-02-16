public class Main {
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<>();
		tree.add("hello");
		tree.add("foo");
		tree.add("1232");
		System.out.println(tree.numberOfElements());
	}
}