
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
    private LesJoueurs lesJ; //Liste des joueurs de la partie
    private PlateauJeu monP; //Plateau associé à la partie
    private Action act; //SAMAN JE SAIS PO
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
       this.indC=0;       
    }
   
    //Méthode pour gérer un tour (permet de déterminer les actions qui suivront, telles que Bataille et Transfert)
    public int traiterTour(Joueur jo, int s) 
    {
        int bonus =-1; 
        Personnage pers = this.lesPers.getPerso(s);
        jo.ajoutePersoPaquet(pers);
        
        String f = pers.getFamille();
        int npf = this.lesPers.getPersosFamille(f).getTaille();

        int npj =jo.getPaquet().getPersosFamille(f).getTaille();

        //Si le joueur a une famille complète
        if(npf==npj){
            //Si cette famille est la famille préférée du joueur
            if(jo.getFamillePref().equals(f)){
                bonus=0;
                //le jeu se termine (appel de la méthode « termineJeu() », du plateau de jeu)
                this.monP.termineJeu();
            }
        }
        else{

            //On parcourt les joueurs pour savoir s'il reste des cartes

            int nbrCartes=0;

            for (int i = 0; i < lesJ.getNbJoueurs(); i++) {
                 nbrCartes +=lesJ.getJoueur(i).getPaquet().getTaille();
            }
            //Si les autres joueurs ont des cartes

            if(nbrCartes!=0){
                if(f.equals("rares") || f.equals("communs")){
                    bonus=1;
                }
                else{
                    if(f.equals("legendaires") || f.equals("epiques")){
                    bonus=2;
                    }
                    else{
                        bonus=3;// cas du combat
                    }
                }
            }
        }

        return bonus;
    }
    
    public int getIndSuivant(int j){ return (j+1)%lesJ.getNbJoueurs(); }
    public Joueur getJoueurCourant(){return lesJ.getJoueur(indC);}
    public Joueur getJoueurSuivant(int j){ return lesJ.getJoueur(getIndSuivant(j)); }
    public boolean finJeu() { return monP.jeuVide();}
    
    public int nbPers(){
    int n = 0;
    for(int i = 0; i < lesJ.getNbJoueurs(); i++)
    if (i !=this.indC) n+=lesJ.getJoueur(i).getPaquet().getTaille();
    return n;
    }

}
