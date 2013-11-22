package command;

public class Insert extends AbstractCommand{
	private String text;
	public Insert(String text) {
		this.text= new String(text);
	}
	@Override
	public void executer() {
	e.insert(text);	
	}
}
