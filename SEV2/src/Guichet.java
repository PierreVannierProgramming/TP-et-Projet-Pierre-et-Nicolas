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
	 * constructeur avec un booleen indiquant si un client est au guichet
	 */
	public Guichet() {
		this.client = false;
	}
	
	/**
	 * geter sur le booleen
	 * @return
	 */
	public boolean getClient(){
		return this.client;
	}
	/**
	 * seter sur le booleen
	 * @param client
	 */
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
	
	
	/**
	 * methode synchronized pour faire entrer un festivalier au guichet,
	 * et lui faire acheter un billet
	 * @param fest
	 */
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
