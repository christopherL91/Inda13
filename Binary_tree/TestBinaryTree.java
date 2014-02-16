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

	@Test(expected = IllegalArgumentException.class)
	public void addElements() {
		assertEquals(true,tree.add("foo"));
		assertEquals(true,tree.add("bar"));
		assertEquals(false,tree.add("foo"));
		tree.add(null);
	}

	@Test
	public void testSize() {
		tree.add("foo");
		tree.add("bar");
		tree.add("hejsan");
		assertEquals(3,tree.numberOfElements());
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void testContains() {
		expectedEx.expect(NoRootException.class);
		expectedEx.expectMessage("Root is not set");
		tree.add("foo");
		tree.add("bar");
		tree.contains("foobar");
	}

	@Test
	public void testHeight() {
		tree.add("hejsan");
		tree.add("foo");
		assertEquals(2,tree.getHeight());
	}

	//@Test
	public void getLeafs() {
		//TODO
	}

	@Test
	public void testPrint() {
		BinaryTree<Integer> numberTree = new BinaryTree<>();
		numberTree.add(2);
		numberTree.add(3);
		numberTree.add(1);
		assertEquals("[1,2,3]",numberTree.toString());
	}
}