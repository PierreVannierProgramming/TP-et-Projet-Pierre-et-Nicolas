package receiver;

public class Selection {
	
	
	private int start;
	
	private int length;
	
	
	public Selection(int s, int l){
		start=s;
		length=l;
	}
	
	public void setSelection(int s, int l) {
		this.start = s;
		this.length = l;
	}
	
	
	public int getStart() {
		return start;
	}
	
	
	
	public int getStartText(){//non teste
		if(this.length>0){
			return start;
		}
		else{
			return this.start + this.length;
		}
	}
	
	public void clearSelection(){
		this.length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	
}



