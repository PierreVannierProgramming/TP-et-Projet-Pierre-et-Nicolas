package receiver;

import gui.window;

public class Engine {

	private int cursor;
	
	private Buffer buffer;
	
	private Selection selection;
	
	private Clipboard clipboard;
	
	public Engine(){
		buffer = new Buffer();
		selection = new Selection(0, 0);
		clipboard = new Clipboard();
	}
	
	public Buffer getBuffer() {
		return buffer;
	}
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public Selection getSelection() {
		return selection;
	}
	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}
	
	public void insertText(Buffer buffer, int debut, String str){//delegate
		this.buffer.insert(debut, str);
	}
	
	public String getSelectedText(){// test ok
		int length = selection.getLength();
		int start = selection.getStart() ;
		if(length < 0){
			return buffer.substring(start + length, start) ;
		}
		else{
			return buffer.substring(start, start + length) ;
		}
	}
	
	public void removeSelectedText(){//test ok
		int length = selection.getLength();
		int start = selection.getStart() ;
		if(length < 0){
			buffer.delete(start + length, start) ;
		}
		else{
			buffer.delete(start, start + length) ;
		}

	}
	public void select(int start, int length)
	{
		selection.setSelection(start, length);
	}
	public void copy()// teste ok
	{
		if(selection.getLength()!=0){
			String s = getSelectedText();
			clipboard.setText(s);
		}
	}
	public void cut()// teste ok
	{
		if(selection.getLength()!=0){
			String s = getSelectedText();
			clipboard.setText(s);
			removeSelectedText();
//			int start = selection.getStart();
			cursor = this.selection.getStartText();
			selection.clearSelection();
		}
	}
	
	public void insert(String text)// teste ok
	{
		removeSelectedText();
		cursor = this.selection.getStartText();
		insertText(buffer, cursor, text);
		cursor += text.length();
	}
		
	
	public void paste()// teste ok
	{
		removeSelectedText();
		cursor = this.selection.getStartText();
		String text = clipboard.getText() ;
		insertText(buffer, cursor, text);
		cursor += text.length();
	}
	
	public static void main(){
		Engine e = new Engine();
		e.getBuffer().addText("azertyuiop");
		e.getSelection().setSelection(0, 0);
		String getxt = e.getSelectedText();
		System.out.println(getxt);
		window w = new window();
	}
}
