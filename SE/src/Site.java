class Site {

/* Constantes associ�es au site */

	
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
	

	public Site (int i){
		this.id = i;
		guichet = new Guichet();
		arret = new Arret();
		}
	
	public int getId() {
		return id;
	}
	
	
	
	
	
}