public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("hello");
		list.addFirst("hejsan");
		list.addFirst("hej");
		list.addLast("christopher");
		System.out.println(list.size());
		list.removeFirst();
		System.out.println(list.size());
	}
}