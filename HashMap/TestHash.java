import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;
	
*/
* updated test class. were doing some really stupid things in the previous version...
*/

public class TestHash {
	private StringHash list;

	@Before
	public void setUp() {
		list = new StringHash(10);
	}
	@After 
	public void tearDown() {
		list = null;
	}

	@Test
	public void addElement() {
		assertEquals(true,list.add("foo"));
		assertEquals(true,list.add("bar"));
		assertEquals(false,list.add("foo"));
	}

	@Test
	public void removeElement() {
		list.add("foo");
		assertEquals(true,list.remove("foo"));
		assertEquals(false,list.remove("foobar"));
	}

	@Test
	public void containsElement() {
		list.add("bar");
		assertEquals(true,list.contains("bar"));
	}
}