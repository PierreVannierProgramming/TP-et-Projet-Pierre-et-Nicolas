import java.util.ArrayList;


public class Navette extends Thread {
	/**
	 * nombre de place dans une navette
	 */
	private static final int nbPlace = 10;
	
	/**
	 * festivalier attendant une navette
	 */
	private ArrayList<Festivalier> listFest;
	/**
	 * geter 
	 * @return
	 */
	public static int getPlace() {
		return nbPlace;
	}
	/**
	 * tableau de site
	 */
	private Site[] circuit;
	/**
	 * constructeur avec une liste de festivalier et le circuit (tableau de site)
	 * @param circuit reference de l'objet circuit
	 */
	public Navette (Site[] circuit){
		this.listFest = new ArrayList<Festivalier>();
		this.circuit = circuit;
		this.setDaemon(true);
	}
	
	/**
	 * geter sur le nombre de passager
	 * @return
	 */
	public int getNbFestivalierCourant() {
		return this.listFest.size();
	}

	/**
	 * ajoute un festivalier à la liste de passager
	 * @param client
	 */
	public void ajoutClient(Festivalier client){
		this.listFest.add(client);
	}
	
	/**
	 * vide la liste des passager
	 */
	public void decendreClient(){
		this.listFest.clear();
	}
	
	/**
	 * lancement du thread associé à une navette,
	 * boucle entre les sites,
	 * sur un site "normal" la navette attend une 1sec,
	 * (temps pour les festivalier de monter)
	 * puis va au site suivant,
	 * une fois au site du festival, la navette fait decendre les passager
	 */
	public void run (){
		int i = 0;
		while(true){
			this.circuit[i].arret.garer(this);
			if (i == circuit.length-1){
				System.out.println(this.getNbFestivalierCourant());
				
				decendreClient();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("test7");
			this.circuit[i].arret.partir();
			i = (i + 1)%circuit.length;
			System.out.println("test100");
		}
	}
		
}
