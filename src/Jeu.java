
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
    private LesPersonnages persos;
    private LesJoueurs joueurs;
    private PlateauJeu monP;
    private Action act;
    private int indice; //Indice du joueur courant

    public LesPersonnages getPersos() {
        return persos;
    }

    public void setPersos(LesPersonnages persos) {
        this.persos = persos;
    }

    public LesJoueurs getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(LesJoueurs joueurs) {
        this.joueurs = joueurs;
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

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
   public Jeu(LesJoueurs lj,LesPersonnages lp,int i)
   {
       setJoueurs(lj);
       setPersos(lp);
       setIndice(i);
       monP = new PlateauJeu(i);       
   }
   
   public int traiteTour(Joueur jc,int index)
   {
       //
       return 0;
   }
    
    
}
