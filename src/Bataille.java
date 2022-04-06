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
        int res=-1;
        if(this.getAdversaire().getPaquet().getTaille()>0 && this.getJ().getPaquet().getTaille()>0)
        {
            Personnage c1 = this.getJ().getPaquet().getPerso(0);
            Personnage c2 = getAdversaire().getPaquet().getPerso(0);
            this.getJ().getPaquet().retirePerso(c1);
            this.getAdversaire().getPaquet().retirePerso(c2);
            if(c1.getValeur()==c2.getValeur())
            {
                res=0;
                this.getJ().getPaquet().ajoutePerso(c1);
                this.getAdversaire().getPaquet().ajoutePerso(c2);
            }
            else
            {
                if(c1.getValeur() > c2.getValeur())
                {
                    res=1;
                    this.getJ().getPaquet().ajoutePerso(c1);
                    this.getJ().getPaquet().ajoutePerso(c2); 
                }
                else
                {
                    res=2;
                    this.getAdversaire().getPaquet().ajoutePerso(c1);
                    this.getAdversaire().getPaquet().ajoutePerso(c2);
                    
                }
                if(this.getJ().getPaquet().getTaille()==0)
                {
                    this.setDeroulement(this.getJ().getPseudo()+" a joué contre "+ this.getAdversaire().getPseudo()+".\n"+this.getAdversaire().getPseudo()+" a gagné");

                }
                else if(this.getAdversaire().getPaquet().getTaille()==0)
                {
                    this.setDeroulement(this.getJ().getPseudo()+" a joué contre "+ this.getAdversaire().getPseudo()+".\n"+this.getJ().getPseudo()+" a gagné");
                }
            }
            
        }
        
        return res;
    }
}