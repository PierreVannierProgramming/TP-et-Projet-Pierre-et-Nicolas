
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
		this.listNav = new ArrayList<Navette>();
	}
	
	public Navette getNav(int i) {
		System.out.println("print i "+i);
		System.out.println("print size i "+this.listNav.size());
		Navette n = this.listNav.get(i);
		 
		System.out.println("test14");
		return n;
	}
	
	public ArrayList<Navette> getListNav() {
		return listNav;
	}
	
	public synchronized void garer(Navette nav){
		this.listNav.add(nav);
		notifyAll();
	}
	
	public Navette partir(){
		System.out.println("test101");
		return this.listNav.remove(0);
	}
	
	
	
	public boolean navettePleine(Festivalier client){
		int i = 0;
		if (this.listNav.size() != 0){
			System.out.println("print size i2 "+this.listNav.size());
			while (this.getNav(i).getNbFestivalierCourant() == Navette.getNbmax() && i<getListNav().size()) {
				i++;}
			if (i==getListNav().size()){return true;}
			else {return false;}
		}
		else {return true;}
	
			
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
