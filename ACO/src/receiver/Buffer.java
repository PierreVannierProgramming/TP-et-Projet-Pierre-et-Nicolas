package receiver;

public class Buffer {
	
	private StringBuilder text;
	
	public Buffer(){
	    text = new StringBuilder();
	}
	
	public String getText() {
		return text.toString();
	}
	
	public void addText(String text) {
		this.text.append(text);
	}
/**
 * 
 * @param start
 * @param end
 * @return
 */
	public String substring(int start,int end) {
		return text.substring(start, end);
	}
	/**
	 * 
	 * @param debut
	 * @param str
	 */
	public void insert(int debut,String str){
		text.insert(debut, str);
	}
	
	/**
	 * 
	 * @param debut
	 * @param fin
	 */
	public void delete(int debut,int fin){
		text.delete(debut, fin);
	}
	
	public void clear(){
		text.delete(0,text.length());
	}
}