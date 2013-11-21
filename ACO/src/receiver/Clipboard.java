package receiver;

public class Clipboard {
	
	private String text;
	
	public Clipboard(){
	    text = new String();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
}