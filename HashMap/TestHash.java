import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.rules.ExpectedException;

/*
* WARNING! Something is wrong with this code.
* Will try to see what is wrong. StringHash works perfectally alone.
*/

public class TestHash {
	private StringHash list;

	public void TestHash() {
		list = new StringHash(10);
	}

	public void doTests() {
		addElement();
		removeElement();
		containsElement();
	}

	@Test
	public void addElement() {
		assertEquals("true",list.add("foo"));
		assertEquals("true",list.add("bar"));
		assertEquals("false",list.add"foo"));
	}

	@Test
	public void removeElement() {
		assertEquals("true",list.remove("foo"));
		assertEquals("false"),list.remove("foobar");
	}

	@Test
	public void containsElement() {
		assertEquals("true",list.contains("bar"));
	}
}