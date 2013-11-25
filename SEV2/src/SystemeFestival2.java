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


/* Cette fonction crée un seul client à la fois.
 * Elle renvoie vrai si et seulement si un client a été créé.
 * Elle renvoie faux dès que la création des clients est terminée. */

/**
 * creation d'un nouveau festivalier, rend vrai si la creation à eu lieu, faux sinon
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

/* Cette fonction crée une seul navette à la fois.
 * Elle renvoie vrai si et seulement si une navette a été créé.
 * Elle renvoie faux dès que la création est terminée. */

/**
 * creation d'une nouvelle navette, rend vrai si la creation à eu lieu, faux sinon
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
 * et lance les threads associé aux festivalers et aux navettes
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
	
	
	/* Lancement des threads associés aux clients */
	for(i = 0; i < nbClients; i++)
		clients[i].start();
	
	
	/* Lancement des threads associés aux navettes */
	for(i = 0; i < nbNav; i++)
		navs[i].start();	
}

/* Point d'entrée du programme */

public static void main(String[] args) {

	new SystemeFestival2();
	}

}
