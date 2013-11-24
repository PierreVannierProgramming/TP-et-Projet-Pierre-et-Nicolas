class Site {

/* Constantes associées au site */

	
	/**
	 * guichet du site
	 */
	public Guichet guichet;
	
	/**
	 * arret du site
	 */
	public Arret arret;
	
	/**
	 * identifiant du Site
	 */
	private int id;
	
	
	/**
	 * nombre de billet sur un site, partager entre les guichets
	 */
	private int nbBillet;
	/**
	 * nombre de guichet dans un site
	 */
	private int nbGuichet;
	/**
	 * tableau de booleen indiquant si les guichets sont occupé
	 */
	private boolean[] tabGuichet = new boolean[nbGuichet];
	/**
	 * constructeur d'un site, contenant un idententifiant, un guichet et un arret
	 * @param i
	 */
	public Site (int i, int nbB, int nbG){
		this.id = i;
		guichet = new Guichet();
		arret = new Arret();
		nbBillet = nbB;
		nbGuichet = nbG;
		}
	/**
	 * geter de l'identifiant du site
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	public boolean guichetsPlein(){
		int i=0;
		while (i!=tabGuichet.length){
			if(tabGuichet[i]){return false;}
			i++;
		}
		return true;
	}
	
	public synchronized void entrerG(Festivalier fest){	
		if (nbBillet!=0){
			int i = 0;
			while (guichetsPlein()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
				}}
			while (tabGuichet[i]){
				i++;
				}				
			tabGuichet[i] = true;
			fest.setBilletAchete(true);
			nbBillet--;
			tabGuichet[i] = false;
			notifyAll();
			}
		System.out.println("plus de billet disponible");
		}
}