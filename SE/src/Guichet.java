//import java.util.ArrayList;


public class Guichet {
	
	/**
	 * client au guichet
	 */
	private boolean client;
	
//	/**
//	 * client en attente d'acceder au guichet
//	 */
//	private ArrayList<Festivalier> listFest;
	

	/**
	 * constructeur
	 */
	public Guichet() {
		this.client = false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getClient(){
		return this.client;
	}
	
	public void setClient(boolean client) {
		this.client = client;
	}
	
//	public void addClient(Festivalier festiv){
//		this.listFest.add(festiv);
//	}
//	
//	public Festivalier removClient(){
//		return this.listFest.remove(0);
//	}
	
	
	
	public synchronized void entrerG(Festivalier fest){
		
		while (getClient()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
		this.setClient(true);
		fest.setBilletAchete(true);
		this.setClient(false);
		notifyAll();
		}

	

}
