package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionTest {

	@Test
	public void test() {

		/**
		 * test des methodes et du constructeur
		 */	
		int deb = 0;
		int len = 100;
		Selection s = new Selection(deb, len);
		assertEquals(len, s.getLength());
		assertEquals(deb, s.getStart());
		
	}

}
