/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aorus
 */
public class Transfert extends Action {
    
    private Joueur cible; //joueur cible du transfert
    private String fp; //famille de la carte sélectionnée
    private LesPersonnages cartesTransferees; // cartes transférées
    
    //Accesseurs des attributs
    public LesPersonnages getCartesTransferees() {
        return cartesTransferees;
    }
    
    public Joueur getJoueurCible(){ 
        return this.cible; 
    }
    
    //Constructeur de la classe à 3 paramètres
    public Transfert(Joueur sc, Joueur c, String f) {
        super(sc, "Transfert de cartes"); //Appel du constructeur de la classe mère
        //Initialisation des attributs
        this.cible = c;
        this.fp = f;
        this.cartesTransferees = new LesPersonnages();
    }
    
    //Gère le transfert de cartes entre deux joueurs
    public int execute() { 
        int res=0;
        if(this.fp != null){ //on vérifie qu'il y a bien une famille sélectionnée, c'est-à-dire une carte sélectionnée
            this.cartesTransferees = this.cible.getPaquet().retirePersosFamille(this.fp); //on stocke l'ensemble des personnages à transférer
            if(this.cartesTransferees.getTaille() != 0){
                res = this.cartesTransferees.getTaille(); //On renvoie le nombre de cartes transférées
                this.getJ().getPaquet().ajoutePersos(cartesTransferees); //on les ajoute au paquet du joueur effectuant la bataille
                this.setDeroulement(this.getJ().getPseudo()+" a récupéré les cartes de la famille "+fp+" de "+this.cible.getPseudo()); //On met à jour le déroulement de cette action
            }
        }
        return res;
    }
}
