/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoar
 */
import java.util.*;
public class LesJoueurs {
    private ArrayList<Joueur> lstJ;
    
    public LesJoueurs(){
        this.lstJ = new ArrayList<Joueur>();
    }
    
    public Joueur getJoueur(int i){
        if(i < lstJ.size() && i>-1)
            return lstJ.get(i);
        else
            return null;
    }
    
    public int getIndiceJoueur(Joueur j){
        return(lstJ.indexOf(j));
    }
    
    public int getNbJoueurs(){
        return this.lstJ.size();
    }
    
    public void ajouteJoueur(Joueur j){
        this.lstJ.add(j);
    }
    
    public void ajouteJoueurs(LesJoueurs j){
        for(int i=0;i<j.getNbJoueurs();i++){
            this.ajouteJoueur(j.getJoueur(i));
        }
    }
    
    public Joueur rechJoueur(String p){
        Joueur j = null;
        for(int i=0;i<getNbJoueurs();i++){
            if(lstJ.get(i).getPseudo().equals(p))
                j = lstJ.get(i);
        }
        return j;
    }
    
    public void supprimeJoueur(Joueur j){
        lstJ.remove(getIndiceJoueur(j));
    }

    public String toString() {
        String s = "";
        for(int i =0;i<lstJ.size();i++){
            s += lstJ.get(i);
        }
        return s;
    }
    
    public LesJoueurs getGagnants(){
        int max= getJoueur(0).getScore();
        for(int i=1; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore();
        LesJoueurs lst=new LesJoueurs();
        for(int i=0; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()==max)
                lst.ajouteJoueur(getJoueur(i));
        return lst;
    }
}
