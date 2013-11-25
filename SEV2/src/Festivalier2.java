
public class  Festivalier2 extends Thread {
	

	/**
	 * site de depart
	 */
	private Site2 siteDepart;
	/**
	 * billet acheté
	 */
	private boolean billetAchete;
	/**
	 * constructeur Client, avec un site de depard, et une variable indiquant si le billet est acheté
	 * @param SD site de depart
	 */
	public Festivalier2 (int nbC, Site2 SD){
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
	 * attend une navette si elles sont toute  pleines,
	 * ne monte pas si il n'a pas son billet
	 * sinon il monte dedans
	 */
	public void run (){
		siteDepart.entrerG(this);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.billetAchete){
			if (siteDepart.getId() != SystemeFestival2.nbSites-1){
				siteDepart.arret2.allinOne(0, null, this);
			}
			System.out.println("tu peut entrer dans le festival");
		}
		else{System.out.println("tu n'as pas acces au festival");}
	}
	
}
