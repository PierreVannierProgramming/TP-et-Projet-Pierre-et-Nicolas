
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
	
	
	
	
	public Arret (){
		this.listNav = new ArrayList<>();
	}
	
	public Navette getNav(int i) {
		return listNav.get(i);
	}
	
	public ArrayList<Navette> getListNav() {
		return listNav;
	}
	
	public void garer(Navette nav){
		this.listNav.add(nav);
		System.out.println("test3");
		notifyAll();
		System.out.println("test5");
	}
	
	public Navette partir(){
		return this.listNav.remove(0);
	}
	
	
	
	public boolean navettePleine(Festivalier client){
		int i = 0;
		while (this.getNav(i).getNbFestivalierCourant() == Navette.getNbmax() && i<getListNav().size()) {
			i++;}
		if (i==getListNav().size()){return true;}
		else {return false;}
	}
	
	
	public synchronized void monterClient(Festivalier client){
		while (navettePleine(client)){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		int i = 0;
		while (this.getNav(i).getNbFestivalierCourant() == Navette.getNbmax()){
			i++;
		}
		getNav(i).ajoutClient(client);
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
