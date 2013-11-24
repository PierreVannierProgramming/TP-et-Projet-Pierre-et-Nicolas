
public class  Festivalier extends Thread {
	

	/**
	 * site de depart
	 */
	private Site siteDepart;
	/**
	 * billet acheté
	 */
	private boolean billetAchete;
	/**
	 * constructeur Client, avec un site de depard, et une variable indiquant si le billet est acheté
	 * @param SD site de depart
	 */
	public Festivalier (int nbC, Site SD){
		this.siteDepart = SD;
		this.billetAchete = false;
	}
	
	/**
	 *setBilletAchete: change la valeur du booleen associé à un festivalier
	 * @param billetAchete
	 */
	public void setBilletAchete(boolean billetA) {
		this.billetAchete = billetA;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * lancement d'un thread festivalier:
	 * le client va au guichet du site où il se trouve, achete un billet,
	 * si le site n'est pas le site du festival, il va à l'arret,
	 * pour attendre une navette si elles sont toute  pleines,
	 * sinon il monte dedans
	 */
	public void run (){
		siteDepart.guichet.entrerG(this);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (siteDepart.getId() != SystemeFestival.nbSites-1){
			System.out.println("test11");
			
			
			siteDepart.arret.monterClient(this);
			
			
			System.out.println("test12");
		}
		System.out.println("test13");
	}
	
}
