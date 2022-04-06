/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unknown
 */
public class Bataille extends Action{
    private Joueur adversaire;

    public Bataille(Joueur sc, Joueur a) 
    {
        super(sc, "Bataille");
        this.adversaire = a;
    }
    public Joueur getAdversaire() 
    { 
        return adversaire ;
    }
    public int execute(){
        int res=
        
    }
}