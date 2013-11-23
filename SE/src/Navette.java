import java.util.ArrayList;


public class Navette extends Thread {
	
	private static final int nbMax = 10;
	
	/**
	 * festivalier attendant une navette
	 */
	private ArrayList<Festivalier> listFest;

	/**
	 * tableau de site
	 */
	public static int getNbmax() {
		return nbMax;
	}
	private Site[] circuit;
	/**
	 * 
	 * @param circuit reference de l'objet circuit
	 * 
	 */
	public Navette (Site[] circuit){
		this.listFest = new ArrayList<Festivalier>();
		this.circuit = circuit;
		this.setDaemon(true);
	}
	
	
	public int getNbFestivalierCourant() {
		return this.listFest.size();
	}

	public void ajoutClient(Festivalier client){
		this.listFest.add(client);
	}
	
	
	public void decendreClient(){
		this.listFest.clear();
	}
	
	public void run (){
		int i = 0;
		while(true){
			System.out.println("test");
			this.circuit[i].arret.garer(this);
			if (i == circuit.length-1){
				decendreClient();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.circuit[i].arret.partir();
			i = (i + 1)%circuit.length;
		}
	}
		
}
