
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
//		this.parcourList = false;
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
	 * pour attendre une navette si elles sont toute pleines
	 * ou si il n'y en a pas,
	 * sinon il monte dedans
	 */
	public void run(){
		siteDepart.guichet.entrerG(this);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (billetAchete){//est toujours le cas dans la V1
			if (siteDepart.getId() != SystemeFestival.nbSites-1){//si on est pas au festival
				siteDepart.arret.allinOne(0, null, this);//cherche à monter dans une navette
			}
		}		
	}
	
}
