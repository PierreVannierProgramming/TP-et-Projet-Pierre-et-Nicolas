
import java.util.ArrayList; 

public class Arret {
//	
//	/**
//	 * festivalier attendant une navette
//	 */
//	private ArrayList<Festivalier> listFest;
//	
	/**
	 * navette en attente
	 */
	private boolean navPresente;
	
	private Navette nav;
	/**
	 * constructeur d'un arret avec une liste de navette
	 */
	public Arret (){
		this.navPresente = false;
	}
	/**
	 * 
	 * @return
	 */
	public boolean getNavPresente(){
		return this.navPresente;
	}
	/**
	 * 
	 * @param navPresente
	 */
	public void setNavPresente(boolean navPresente) {
		this.navPresente = navPresente;
	}
	
	public Navette getNav() {
		return nav;
	}
	
//	/**
//	 * geter sur la navette i de la liste
//	 * @param i
//	 * @return
//	 */
//	public Navette getNav(int i) {
//		System.out.println("print i "+i);
//		System.out.println("print size i "+this.listNav.size());
//		Navette n = this.listNav.get(i);
//		 
//		System.out.println("test14");
//		return n;
//	}
	
//	/**
//	 * geter sur la liste des navettes
//	 * @return
//	 */
//	public ArrayList<Navette> getListNav() {
//		return listNav;
//	}
	
	/**
	 * methode permetant au navette de se garer,
	 * en s'ajoutant en fin de liste
	 * @param nav
	 */

	public synchronized void garer(Navette nave){
		while (getNavPresente()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			setNavPresente(true);
			nav = nave;
			notifyAll();
	}
	//cette listes de navette est une FIFO
	/**
	 * methode permetant au navette de partir,
	 * en suprimant le premiere element de la liste
	 * @return
	 */
	public synchronized void partir(){
		System.out.println("test101");
		notifyAll();
	}
	
//	/**
//	 * cette methode test si toutes les navettes sont pleine
//	 * @param client
//	 * @return
//	 */
//	public boolean navettePleine(){
//		int i = 0;
//		if (!getNavPresente()){// si la liste est vide on retourne true
//			System.out.println("print size i2 ");
//			while (this.getNav(i).getNbFestivalierCourant() == Navette.getPlace() && i<getListNav().size()) {
//				i++;}
//			if (i==getListNav().size()){return true;}
//			else {return false;}
//		}
//		else {return true;}	
//	}
	
	/**
	 * methode synchronized permetant au festivalier de monter dans une navette
	 * @param client
	 */
	public synchronized void monterClient(Festivalier client){
		boolean monter = false;
		while (!monter){
			while (!getNavPresente()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
			if (this.getNav().getNbFestivalierCourant() < Navette.getPlace()){
				getNav().ajoutClient(client);
				monter = true;
			}
		}
		notifyAll();
	}
}
