import java.util.ArrayList;


public class Navette extends Thread {
	/**
	 * nombre de place dans une navette
	 */
	private static final int nbMaxPlace = 10;
	
	/**
	 * festivalier attendant une navette dans cette liste de navette
	 */
	private ArrayList<Festivalier> listFest;
	/**
	 * geter 
	 * @return
	 */
	public static int getMaxPlace() {
		return nbMaxPlace;
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
	}
	
	/**
	 * Getter sur le nombre de passager
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
			this.circuit[i].arret.allinOne(1, this, null);//la navette se gare
			if (i == circuit.length-1){//si la navette est au festival
				System.out.println("nombre de personne decendant au festival "+this.getNbFestivalierCourant());
				
				decendreClient();
			}
			try {
				Thread.sleep(1000);//attente dans les arrets
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.circuit[i].arret.allinOne(2, null, null);//la navette part du site
			i = (i + 1)%circuit.length;//la navette va au site suivant
		}
	}
		

}
