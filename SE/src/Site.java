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
	 * constructeur d'un site, contenant un idententifiant, un guichet et un arret
	 * @param i
	 */
	public Site (int i){
		this.id = i;
		guichet = new Guichet();
		arret = new Arret();
		}
	/**
	 * geter de l'identifiant du site
	 * @return
	 */
	public int getId() {
		return id;
	}
	
}