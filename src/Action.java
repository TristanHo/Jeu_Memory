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
	public Action(){
		this.j = null;
                this.descriptif ="";
                this.deroulement="";
        }
	public Action(Joueur jc, String d){
		this.j = jc ; 
                this.descriptif = d;
                this.deroulement="";}
	//getter,setter des attributs
	public String toString(){
		String s ="";
		s+= "Action effectuée par"+this.j.getPseudo() + "\n";
		s+= "Descriptif : "+this.descriptif+"\n";
		s+="Deroulement : "+this.deroulement+"\n";
		return s;}
	public abstract int execute();
}//fin de la classe

