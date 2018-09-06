import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}

	//TODO write more tests. Test other cases.
	@Test
	public void testNotElementInArray() {
		String[] fruit = {"Apple"};
		assertEquals(-1, StringUtil.indexOf("Banana", fruit));
	}
	
	@Test
	public void testDuplicatedElement() {
		String[] fruit = {"Apple", "Apple", "Banana", "Apple", "Banana"};
		assertEquals(0,StringUtil.indexOf("Apple", fruit));
		assertEquals(2, StringUtil.indexOf("Banana", fruit));
	}
}
