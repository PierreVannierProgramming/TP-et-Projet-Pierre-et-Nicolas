package receiver;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import receiver.Buffer;

public class EngineTest extends Engine {
	private Engine engine;
	
	@Before
	public void init(){
		engine = new Engine();
	}
	
	@Test
	public void getSelectedTextTest() {

		engine.getBuffer().addText("azertyuiop");
		
		engine.getSelection().setSelection(1, 0);
		String getxt = engine.getSelectedText();
		assertEquals(getxt, "");
		
		engine.getSelection().setSelection(1, 6);
		getxt = engine.getSelectedText();
		assertEquals(getxt, "zertyu");
		
		engine.getSelection().setSelection(8, -2);
		getxt = engine.getSelectedText();
		assertEquals(getxt, "ui");
	}
	
	@Test
	public void removeSelectedTextTest() {
		String getxt;
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 6);
		engine.removeSelectedText();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "aiop");
		
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 0);
		engine.removeSelectedText();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azertyuiop");
		
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(8, -2);
		engine.removeSelectedText();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azertyop");
	}
	@Test
	public void select() {
		int begin = 3;
		int length = 2;
		engine.getBuffer().addText("azertyuiop");
		engine.select(begin, length);
		Selection sel = engine.getSelection();
		assertEquals(begin, sel.getStart());
		assertEquals(length,sel.getLength());
	}
	@Test
	public void copy() {
		String getxt;
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 0);
		engine.copy();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "");
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 5);
		engine.copy();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "zerty");
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(8, -5);
		engine.copy();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "rtyui");
	}
	
	@Test
	public void cut() {
		String getxt;
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 0);
		engine.cut();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azertyuiop");

		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(1, 5);
		engine.cut();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "zerty");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "auiop");
		
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(8, -5);
		engine.cut();
		getxt = engine.getClipboard().getText();
		assertEquals(getxt, "rtyui");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azeop");
	}
	
	@Test
	public void insert() {
		String getxt;
		
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(3, 0);
		engine.insert("test");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azetestrtyuiop");
	
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(2, 6);
		engine.insert("test");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "aztestop");
		
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getSelection().setSelection(8, -5);
		engine.insert("test");
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azetestop");
	}
		
	@Test
	public void paste() {
		String getxt;
		
		engine.getBuffer().addText("azertyuiop");
		engine.getClipboard().setText("trololo");
		engine.getSelection().setSelection(3, 0);
		engine.paste();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azetrololortyuiop");
	
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getClipboard().setText("trololo");
		engine.getSelection().setSelection(2, 7);
		engine.paste();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "aztrololop");
		
		engine.getBuffer().clear();
		engine.getBuffer().addText("azertyuiop");
		engine.getClipboard().setText("trololo");
		engine.getSelection().setSelection(8, -5);
		engine.paste();
		getxt = engine.getBuffer().getText();
		assertEquals(getxt, "azetrololoop");
	}
}
