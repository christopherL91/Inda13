import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.rules.ExpectedException;

public class RunTests {
	LinkedList<String> list;

	public RunTests() {
		list = new LinkedList<String>();
	}

	public void tearDown() {
		list.clear();
	}

	@Test
	public void testadd() {
		list.addFirst("Kalle");
		list.addFirst("Lisa");
		list.addLast("John");
		assertEquals(3,list.size());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void testGetLast() {
		list.addFirst("Lisa");
		list.addFirst("John");
		assertEquals("Lisa",list.getLast());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void getOutput() {
		list.addFirst("lisa");
		list.addFirst("Kalle");
		list.addLast("John");
		assertEquals("[Kalle, lisa, John]",list.toString());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void testRemoveFirst() {
		list.addFirst("Kalle");
		list.addFirst("John");
		list.removeFirst();
		assertEquals("[Kalle]",list.toString());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void getElement() {
		list.addFirst("Kalle");
		list.addFirst("Anna");
		assertEquals(null,list.get(2));
		assertEquals(null,list.get(-2));
		assertEquals("Anna",list.get(0));
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void testEmpty() {
		list.clear();
		assertEquals(true,list.isEmpty());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void clearList() {
		list.clear();
		assertEquals(0,list.size());
		assertEquals(true,list.isHealthy());
		tearDown();
	}

	@Test
	public void runTests() {
		testadd();
		getElement();
		getOutput();
		clearList();
		testEmpty();
		testRemoveFirst();
		testGetLast();
	}
}