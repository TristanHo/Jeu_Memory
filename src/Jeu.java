
import javax.swing.Action;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unknown
 */
public class Jeu {
    
    private LesPersonnages lesPers; //Liste des personnages de la partie
    private LesJoueurs lesJ; //Les joueurs qui ont été choisis ou ajoutés pour la partie en cours,
    private PlateauJeu monP; //Plateau associé à la partie
    private Action act; //L’action que va réaliser le joueur (selon les cartes du joueur qui est en train de jouer).
    private int indC; //Indice du joueur courant

    //Accesseurs des attributs
    public LesPersonnages getLesPers() {
        return lesPers;
    }

    public void setLesPers(LesPersonnages lesPers) {
        this.lesPers = lesPers;
    }

    public LesJoueurs getLesJ() {
        return lesJ;
    }

    public void setLesJ(LesJoueurs lesJ) {
        this.lesJ = lesJ;
    }

    public int getIndC() {
        return indC;
    }

    public void setIndC(int indC) {
        this.indC = indC;
    }

    public PlateauJeu getMonP() {
        return monP;
    }

    public void setMonP(PlateauJeu monP) {
        this.monP = monP;
    }

    public Action getAct() {
        return act;
    }

    public void setAct(Action act) {
        this.act = act;
    }
    
    //Constructeur de la classe
    public Jeu(LesPersonnages lp, LesJoueurs lj, int nbc)
    {
       this.lesPers=lp;
       this.monP=new PlateauJeu(nbc);
       this.lesJ=lj;
       this.act=null;
       this.indC=0;  //On initilaise le joueur courant à 0 pour prendre le premier personnage de la liste des joueurs     
    }
   
    //Méthode pour gérer un tour (permet de déterminer les actions qui suivront, telles que Bataille et Transfert)
    public int traiterTour(Joueur jo, int s) 
    {
        int bonus =-1; //Initialisation de la valeur du bonus à -1
        Personnage pers = this.lesPers.getPerso(s);//Récupération du personnage gagné nommé « pers »
        jo.ajoutePersoPaquet(pers);//Ajout de ce personnage dans le paquet du joueur courant

        
        String f = pers.getFamille();//Récupération de la famille nommée « f » du personnage gagné « pers »
        
        int npf = this.lesPers.getPersosFamille(f).getTaille();//Récupération du nombre de personnages de cette famille nommé « npf » dans le jeu (pour l’ensemble des personnages)

        int npj =jo.getPaquet().getPersosFamille(f).getTaille();//Récupération du nombre de personnages de cette famille nommé « nbj » dans le paquet du joueur courant

        //Si le joueur a une famille complète
        if(npf==npj){
            //Si cette famille est la famille préférée du joueur
            if(jo.getFamillePref().equals(f)){
                bonus=0;
                //le jeu se termine (appel de la méthode « termineJeu() », du plateau de jeu)
                this.monP.termineJeu();
            }
            else{

                //On parcourt les joueurs pour savoir s'il reste des cartes
                int nbrCartes = nbPers();
                
                if(nbrCartes!=0){//Si les autres joueurs ont des cartes
                    if(f.equals("rares") || f.equals("communs")){//Si la famille gagnée est « rares » ou « communs »
                        bonus=1;// Alors le bonus vaut 1, (Action Transfert)
                    }
                    else{
                        if(f.equals("legendaires") || f.equals("epiques")){//Si la famille gagnée est « legendaires » ou«epiques »

                        bonus=2;//Alors le bonus vaut 2 (Action Bataille)
                        }
                        else{//Sinon le bonus vaut 3 (Action Combat)
                            bonus=3;// cas du combat
                        }
                    }
                }
            }
        }
        return bonus; //On retourne le bonus (int)
    }
    
    public int getIndSuivant(int j){//Retourner l'indice du joueur suivants
        
        
        return (j+1)%lesJ.getNbJoueurs();//le modulo permet de ne pas dépasser le nombre des joueurs
    }
    public Joueur getJoueurCourant(){//Retourner l'indice du joueur courant
        return lesJ.getJoueur(indC);
    }
    public Joueur getJoueurSuivant(int j){//Retourner le joueur suivant
        
        return lesJ.getJoueur(getIndSuivant(j)); //On utilise la méthode getIndSuivant(int j) j est le joueur courant
    }
    public boolean finJeu() { //Méthode pour finir le jeu
        return monP.jeuVide();//Appel de la méthode JeuVide pour vérifier si touts les cases ont été dévoilées
    }
    
    //Méthode qui parcourt les joueurs pour savoir s'il reste des cartes dans le jeu
    public int nbPers(){
        int n = 0;//On initialise n à 0
        for(int i = 0; i < lesJ.getNbJoueurs(); i++) 
            if (i !=this.indC)//On exclue le joueur courant
                n+=lesJ.getJoueur(i).getPaquet().getTaille();//On ajoute le nombre des personnages de chaque joueur 
        return n;
    }

}
