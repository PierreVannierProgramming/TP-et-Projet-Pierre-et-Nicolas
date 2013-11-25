class SystemeFestival2 {

/* Constantes */

static final int nbSites = 7;
static final int nbFestivalier = 100;
static final int nbNavette = 3;
static final int nbBillet = 20;
static final int nbGuichet = 5;


private Site2[] site2s = new Site2[nbSites];
private Festivalier2[] clients = new Festivalier2[nbFestivalier];
private int nbClients = 0;
private Navette2[] navs = new Navette2[nbNavette];
private int nbNav = 0;


/* Cette fonction cr�e un seul client � la fois.
 * Elle renvoie vrai si et seulement si un client a �t� cr��.
 * Elle renvoie faux d�s que la cr�ation des clients est termin�e. */

/**
 * creation d'un nouveau festivalier, rend vrai si la creation � eu lieu, faux sinon
 */
private boolean nouveauClient() {

	Site2 depart;
	
	if(nbClients == nbFestivalier) {
		System.out.println("Le nombre maximum de clients est atteint.");
		return false;
	}
	//generation aleatoire d'un site pour les festivalier
	int d = (int) Math.abs(Math.random() * nbSites);
	depart = site2s[d];

	clients[nbClients] = new Festivalier2(nbClients, depart);
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
	navs[nbNav] = new Navette2(site2s);
	nbNav++;

	return true;
}


/**
 * systeme creant les sites, festivaliers et navettes,
 * et lance les threads associ� aux festivalers et aux navettes
 */
SystemeFestival2() {

	int i;

	/* Instanciation des sites */
	for(i = 0; i < nbSites; i++){
		//generation aleatoire d'un nombre de billet pour les sites
		int b = (int) Math.abs(Math.random() * nbBillet);
		//generation aleatoire d'un nombre de guichet pour les sites
		int g = (int) Math.abs(Math.random() * nbGuichet);
		site2s[i] = new Site2(i, b, g);
		
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

	new SystemeFestival2();
	}

}
