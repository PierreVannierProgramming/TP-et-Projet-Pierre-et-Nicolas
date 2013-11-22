package receiver;


import static org.junit.Assert.*;

import org.junit.Test;

import receiver.Buffer;

public class BufferTest {

	@Test
	public void testBuffer() {
		
		/**
		 * test des methodes et du constructeur
		 */	
		String s = "hello world";
		Buffer b = new Buffer();
		b.addText(s);
		assertEquals(s, b.getText());
		
		/**
		 * test sur une chaine vide
		 */
		Buffer b2 = new Buffer();
		assertEquals("",b2.getText());
		
	}
}
