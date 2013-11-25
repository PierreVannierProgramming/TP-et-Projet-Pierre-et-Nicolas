import java.util.ArrayList; 

public class Arret {

	/**
	 * liste des navettes en attente
	 */
	private ArrayList<Navette> listNav;
	
	/**
	 * cette variable indique si un client parcour la liste des navettes
	 */
	private boolean parcourList;
	
	/**
	 * constructeur d'un arret avec une liste de navette
	 */
	public Arret (){
		this.listNav = new ArrayList<Navette>();
		this.parcourList = false;
	}
	
	/**
	 * geter sur la navette i de la liste
	 * @param i
	 * @return
	 */
	public Navette getNav(int i) {
		Navette n = this.listNav.get(i);
		return n;
	}
	/**
	 * indique qu'au moins un festivalier parcour la liste des navettes
	 * @return
	 */
	public boolean getparcourList(){
		return this.parcourList;
	}
	/**
	 * seter sur parcourList
	 * @param test
	 */
	public void veutMonter(boolean test){
		this.parcourList = test;
	}
	
	/**
	 * Getter sur la liste des navettes
	 * @return
	 */
	public ArrayList<Navette> getListNav() {
		return listNav;
	}
	
	/**
	 * methode permetant au navette de se garer,
	 * en s'ajoutant en fin de liste
	 * @param nav
	 */
	public void garer(Navette nav){
		this.listNav.add(nav);
	}
	//cette listes de navette est une FIFO
	/**
	 * methode permetant au navette de partir,
	 * en suprimant le premiere element de la liste
	 * @return
	 */
	public void partir(){
			this.listNav.remove(0);
	}
	
	/**
	 * cette methode test si toutes les navettes sont pleine
	 * @param client
	 * @return
	 */
	public boolean navettePleine(){
		int i = 0;
		if (0!=this.listNav.size()){// si la liste est vide on retourne true
			while (i<getListNav().size() && this.getNav(i).getNbFestivalierCourant() == Navette.getMaxPlace()) {
				i++;}
			if (i==getListNav().size()){return true;}//toute les navettes sont pleine
			else {return false;}
		}
		else {return true;}	
	}
	
	/**
	 * methode synchronized permetant au festivalier de monter dans une navette
	 * @param client
	 */
	public void monterClient(Festivalier client){
		while (navettePleine()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		int i = 0;
		while (this.getNav(i).getNbFestivalierCourant() == Navette.getMaxPlace()){
			i++;//on reparcours la liste pour trouver la navette non pleine
		}
		getNav(i).ajoutClient(client);
		System.out.println("client monte");
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
	public synchronized void allinOne(int i, Navette nav, Festivalier fest){
		switch (i) {
		case 0:
			//case du festivalier demandant à monter dans une navette
			monterClient(fest);
			break;
		case 1:
			//case d'une navette voulant se garer
			garer(nav);
			notifyAll();//reveille les festivalier en attente d'une navette
			break;
		case 2:
			//case d'une navette vaulant partir
			partir();
			break;
		default:
			break;
		}
	}
	
}
