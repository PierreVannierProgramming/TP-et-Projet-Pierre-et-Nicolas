class Site2 {

/* Constantes associées au site */
	
	/**
	 * arret du site
	 */
	public Arret2 arret2;
	
	/**
	 * identifiant du Site
	 */
	private int id;
	
	
	/**
	 * nombre de billet sur un site, partager entre les guichets
	 */
	private int nbBillet;

	/**
	 * tableau de booleen indiquant si les guichets sont occupé
	 */
	private boolean[] tabGuichet;
	/**
	 * constructeur d'un site, contenant un idententifiant,
	 * un tableau de booleen corespondant si un client est au guichet et un arret
	 * @param i
	 */
	public Site2 (int i, int nbB, int nbG){
		this.id = i;
		arret2 = new Arret2();
		nbBillet = nbB;
		tabGuichet = new boolean[nbG];
		for (int j = 0; j<tabGuichet.length; j++){
			tabGuichet[j] = false;
		}
		}
	/**
	 * Getter de l'identifiant du site
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * test si les guichets sont plein (si tout le tableau est à vrai)
	 * @return
	 */
	public boolean guichetsPlein(){
		int i=0;
		while (i<tabGuichet.length){
			if(!tabGuichet[i]){return false;}
			i++;
		}
		return true;
	}
	
	/**
	 * méthode synchronized permetant au client d'acheter leur billet,
	 * il peuvent ne pas en avoir si rupture de stock
	 * @param fest
	 */
	public synchronized void entrerG(Festivalier2 fest){	
		if (nbBillet!=0){//si il y a encore des billets
			int i = 0;
			while (guichetsPlein()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
				}}
			while (tabGuichet[i]){//on parcours le tableau de guichet pour trouver le guichet que l'ancien festivalier vient quitter
				i++;
				}				
			tabGuichet[i] = true;
			fest.setBilletAchete(true);
			nbBillet--;
			System.out.println("nombre de billet restant :"+nbBillet);
			tabGuichet[i] = false;
			notifyAll();
			}
		System.out.println("plus de billet disponible");
		}
}