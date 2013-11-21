package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import receiver.Clipboard;

public class ClipboardTest {

	@Test
	public void testClipboard() {
		
		/**
		 * test des methodes et du constructeur
		 */	
		String s = "hello world";
		Clipboard b = new Clipboard();
		b.setText(s);
		assertEquals(s, b.getText());
		
		/**
		 * test sur une chaine vide
		 */
		Clipboard b2 = new Clipboard();
		assertEquals("",b2.getText());
	}
}