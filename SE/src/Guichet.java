public class Guichet {
	
	/**
	 * booleen indiquant si un client au guichet
	 */
	private boolean client;
	
	/**
	 * constructeur avec un booleen indiquant si un client est au guichet
	 */
	public Guichet() {
		this.client = false;
	}
	
	/**
	 * Getter sur le booleen
	 * @return
	 */
	public boolean getClient(){
		return this.client;
	}
	/**
	 * Setter sur le booleen
	 * @param client
	 */
	public void setClient(boolean client) {
		this.client = client;
	}
	
	/**
	 * methode synchronized :
	 * fait entrer un festivalier au guichet,
	 * et lui fait acheter un billet
	 * @param fest
	 */
	public synchronized void entrerG(Festivalier fest){
		fest.setBilletAchete(true);//la variale associé au client passe à vrai
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
