
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
	 * constructeur Client
	 * @param SD site de depart
	 */
	public Festivalier (int nbC, Site SD){
		this.siteDepart = SD;
		this.billetAchete = false;
	}
	
	/**
	 * 
	 * @param billetAchete
	 */
	public void setBilletAchete(boolean billetAchete) {
		this.billetAchete = billetAchete;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
