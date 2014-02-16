import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;

public class TestBinaryTree {
	private BinaryTree<String> tree;

	public static void main(String[] args) {
	TestBinaryTree test = new TestBinaryTree();
}

	@Before
	public void setUp() {
		tree = new BinaryTree<>();
	}

	@After
	public void tearDown() {
		tree = null;
	}

	@Test
	public void addElements() {
		assertEquals(true,tree.add("foo"));
		assertEquals(true,tree.add("bar"));
		//assertEquals(false,tree.add("foo"));
	}
}