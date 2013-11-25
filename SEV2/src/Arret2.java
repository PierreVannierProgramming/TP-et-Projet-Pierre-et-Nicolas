public class Arret2 {

	/**
	 * navette en attente
	 */
	private boolean navPresente;
	/**
	 * navette atribué à l'arret
	 */
	private Navette2 nav;
	/**
	 * constructeur d'un arret avec une liste de navette
	 */
	public Arret2 (){
		this.navPresente = false;
		nav = null;
	}
	/**
	 * 
	 * @return
	 */
	public boolean getNavPresente(){
		return this.navPresente;
	}
	/**
	 * Setter sur navPresente
	 * @param navPresente
	 */
	public void setNavPresente(boolean navPresente) {
		this.navPresente = navPresente;
	}
	/**
	 * Getter sur la navette de l'arret
	 * @return
	 */
	public Navette2 getNav() {
		return nav;
	}
	
	/**
	 * methode permetant au navette de se garer,
	 * attend si une autre navette est presente
	 * @param nav
	 */
	public void garer(Navette2 nave){
		while (getNavPresente()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			setNavPresente(true);
			nav = nave;//modifie la navette presente à l'arret
	}
	/**
	 * methode permetant au navette de partir,
	 * @return
	 */
	public synchronized void partir(){
		nav = null;
		setNavPresente(false);
	}
	
	/**
	 * navPleine test si la navette est pleine
	 * @return
	 */
	public boolean navPleine(){
		if (nav != null){	
			if (getNav().getNbFestivalierCourant() < Navette2.getPlace()){
				return false;}
			else{return true;}
		}
		else{return true;}
	}
	/**
	 * methode synchronized permetant au festivalier de monter dans une navette
	 * @param client
	 */
	public synchronized void monterClient(Festivalier2 client){
			while (!getNavPresente() || navPleine()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				getNav().ajoutClient(client);//le client monte dans la navette
	}
	
	/**
	 * methode synchronized principal appelé par un Festivalier ou une Navette,
	 * elle contiend un switche pour les différents cas d'utilisation,
	 * 0:pour faire monter un festivalier dans navette 
	 * 1:pour faire garer une navette
	 * 2:pour faire partir une navette
	 * @param i
	 * @param nav
	 * @param fest
	 */
	public synchronized void allinOne(int i, Navette2 nav, Festivalier2 fest){
		switch (i) {
		case 0:
			//case du festivalier demandant à monter dans une navette
			monterClient(fest);
			break;
		case 1:
			//case d'une navette voulant se garer
			garer(nav);
			notifyAll();// reveille les client attendant une navette
			break;
		case 2:
			//case d'une navette vaulant partir
			partir();
			notifyAll();//reveille des navettes en attente de se garer
			break;
		default:
			break;
		}
	}
}
