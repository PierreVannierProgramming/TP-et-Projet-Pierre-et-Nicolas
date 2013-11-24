class SystemeFestival {

/* Constantes (final indique que la valeur ne peut pas changer) */

static final int nbSites = 7;
static final int nbFestivalier = 100;
static final int nbNavette = 8;
static final int nbBillet = 20;
static final int nbGuichet = 5;

/* Ces attributs sont statiques */

private Site[] sites = new Site[nbSites];
private Festivalier[] clients = new Festivalier[nbFestivalier];
private int nbClients = 0;
private Navette[] navs = new Navette[nbNavette];
private int nbNav = 0;


/* Cette fonction cr�e un seul client � la fois (� la limite aucun).
 * Elle renvoie vrai si et seulement si un client a �t� cr��.
 * Elle renvoie faux d�s que la cr�ation des clients est termin�e. */

/**
 * creation d'un nouveau festivalier, rend vrai si la creation � eu lieu, faux sinon
 */
private boolean nouveauClient() {

	Site depart;
	
	if(nbClients == nbFestivalier) {
		System.out.println("Le nombre maximum de clients est atteint.");
		return false;
	}
	//generation aleatoire d'un site pour les festivalier
	int d = (int) Math.abs(Math.random() * nbSites);
	depart = sites[d];

	clients[nbClients] = new Festivalier(nbClients, depart);
	nbClients++;

	return true;
}

/* Cette fonction cr�e une seul navette � la fois.
 * Elle renvoie vrai si et seulement si une navette a �t� cr��.
 * Elle renvoie faux d�s que la cr�ation est termin�e. */

/**
 * creation d'une nouvelle navette, rend vrai si la creation � eu lieu, faux sinon
 */
private boolean nouvelleNavette() {

	if(nbNav == nbNavette) {
		System.out.println("Le nombre maximum de navette est atteint.");
		return false;
	}
	navs[nbNav] = new Navette(sites);
	nbNav++;

	return true;
}

/* Constructeur. Il est appel� lors de l'instanciation du syst�me d'emprunt. */

/**
 * systeme creant les sites, festivaliers et navettes,
 * et lance les threads associ� aux festivalers et aux navettes
 */
SystemeFestival() {

	int i;

	/* Instanciation des sites */
	for(i = 0; i < nbSites; i++){
		//generation aleatoire d'un nombre de billet pour les sites
		int b = (int) Math.abs(Math.random() * nbBillet);
		//generation aleatoire d'un nombre de guichet pour les sites
		int g = (int) Math.abs(Math.random() * nbGuichet);
		sites[i] = new Site(i, b, g);
	}

	/* Instanciation des festivaliers */
	while(nouveauClient());

	/* Instanciation des navettes */
	while(nouvelleNavette());
	
	
	/* Lancement des threads associ�s aux clients */
	for(i = 0; i < nbClients; i++)
		clients[i].start();
	
	
	/* Lancement des threads associ�s aux navettes */
	for(i = 0; i < nbNav; i++)
		navs[i].start();

	
}

/* Point d'entr�e du programme */

public static void main(String[] args) {

	new SystemeFestival();
	}

}
