/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unknown
 */
public class Bataille extends Action{
    
    //attribut de la classe
    private Joueur adversaire;
    
    //constructeur de la classe
    public Bataille(Joueur sc, Joueur a) 
    {
        super(sc, "Bataille"); //appel au constructeur de la classe-mère
        this.adversaire = a;
    }
    
    //accesseur de l'attribut
    public Joueur getAdversaire() 
    { 
        return adversaire ;
    }
    
    //Méthode execute (définit ce qu'il se passe lors d'une action de type bataille et les transferts de carte qui en résultent)
    public int execute(){
        int res=-1;
        if(this.getAdversaire().getPaquet().getTaille()>0 && this.getJ().getPaquet().getTaille()>0) //s'il reste des cartes à l'adversaire et au joueur courant
        {   
            //On stocke les premiers personnages des paquets de chaque joueur
            Personnage c1 = this.getJ().getPaquet().getPerso(0);
            Personnage c2 = getAdversaire().getPaquet().getPerso(0);
            //On les retire des paquets
            this.getJ().getPaquet().retirePerso(c1);
            this.getAdversaire().getPaquet().retirePerso(c2);
            
            if(c1.getValeur()==c2.getValeur()) //Si les deux personnages ont la même valeur
            {
                res=0; //Le résultat est affecté à 0
                //On replace les personnages dans leurs paquets respectifs
                this.getJ().getPaquet().ajoutePerso(c1);
                this.getAdversaire().getPaquet().ajoutePerso(c2);
            }
            else
            {//Si la valeur de c1 est supérieure à celle de c2
                if(c1.getValeur() > c2.getValeur())
                {
                    res=1; //Le résultat est affecté à 1
                    /*Les deux cartes sont ajoutées au joueur courant (les ajouts sont faits par défaut en
                    fin de liste, ce qui simule le fait de mettre une carte en dessous du paquet)*/
                    this.getJ().getPaquet().ajoutePerso(c1);
                    this.getJ().getPaquet().ajoutePerso(c2); 
                }
                else
                {
                    res=2; //Le résultat est affecté à 2
                    //Les deux cartes sont ajoutés à l'adversaire du joueur courant
                    this.getAdversaire().getPaquet().ajoutePerso(c1);
                    this.getAdversaire().getPaquet().ajoutePerso(c2);
                    
                }
            }
            
            //Si le joueur courant n'a plus de personnages dans son paquet, c'est-à-dire que l'adversaire a gagné
            if(this.getJ().getPaquet().getTaille()==0)
            {
                this.setDeroulement(this.getJ().getPseudo()+" a joué contre "+ this.getAdversaire().getPseudo()+".\n"+this.getAdversaire().getPseudo()+" a gagné");

            }
            
            //Sinon, si l'adversaire n'a plus de personnages dans son paquet, c'est-à-dire que le joueur courant a gagné
            else if(this.getAdversaire().getPaquet().getTaille()==0)
            {
                this.setDeroulement(this.getJ().getPseudo()+" a joué contre "+ this.getAdversaire().getPseudo()+".\n"+this.getJ().getPseudo()+" a gagné");
            }
            
        }
        
        return res; //On renvoie le résultat pour connaître le résultat de la bataille
    }
}