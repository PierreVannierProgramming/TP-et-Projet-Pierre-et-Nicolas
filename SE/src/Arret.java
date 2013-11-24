
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
	public synchronized Navette getNav(int i) {
		System.out.println("print i "+i);
		System.out.println("print size i "+this.listNav.size());
		
		
		Navette n = this.listNav.get(i);
		 
		
		System.out.println("test14");
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
	 * geter sur la liste des navettes
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
	public synchronized void garer(Navette nav){
		this.listNav.add(nav);
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
		while (getparcourList()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			this.listNav.remove(0);
			notifyAll();
	}
		
	
	
	
	
	
	/**
	 * cette methode test si toutes les navettes sont pleine
	 * @param client
	 * @return
	 */
	public boolean navettePleine(){
		int i = 0;
		if (0!=this.listNav.size()){// si la liste est vide on retourne true
			System.out.println("print size i2 "+this.listNav.size());
			while (this.getNav(i).getNbFestivalierCourant() == Navette.getMaxPlace() && i<getListNav().size()) {
				i++;}
			if (i==getListNav().size()){return true;}
			else {return false;}
		}
		else {return true;}
	
			
	}
	
	/**
	 * methode synchronized permetant au festivalier de monter dans une navette
	 * @param client
	 */
	public synchronized void monterClient(Festivalier client){
		this.veutMonter(true);
		while (navettePleine()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		int i = 0;
		while (this.getNav(i).getNbFestivalierCourant() == Navette.getMaxPlace()){
			i++;
		}
		getNav(i).ajoutClient(client);
		
		this.veutMonter(false);
		notifyAll();

	}
	
	
//	public void addClient(Festivalier festiv){
//		this.listFest.add(festiv);
//	}
//	
//	public Festivalier removClient(){
//		return this.listFest.remove(0);
//	}
	
//	public void garer(Navette nav){
//		addNav(nav);
//		
//	}
	
}
