/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unknown
 */
public abstract class Action {
    
    //attributs
    private Joueur j;
    private String descriptif;
    private String deroulement;
    
    //accesseurs des attributs
    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDeroulement() {
        return deroulement;
    }

    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }
    
    //Constructeur par défaut
    public Action(){
            this.j = null;
            this.descriptif ="";
            this.deroulement="";
    }
    
    //Constructeur avec deux paramètres : joueur et descriptif de l'action
    public Action(Joueur jc, String d){
            this.j = jc ; 
            this.descriptif = d;
            this.deroulement="";}

    
    public String toString(){
            String s ="";
            s+= "Action effectuée par"+this.j.getPseudo() + "\n";
            s+= "Descriptif : "+this.descriptif+"\n";
            s+="Deroulement : "+this.deroulement+"\n";
            return s;}
    
    //Méthode abstraite execute (le corps de cette méthode est remplie dans les autres classes)
    public abstract int execute();
}//fin de la classe

