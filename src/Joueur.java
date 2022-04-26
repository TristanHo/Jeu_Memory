
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoar
 */
public class Joueur {
    
    //déclaration des attributs
    private String pseudo;
    private String famillePref;
    private LesPersonnages paquet;
    private ImageIcon photo;
    
    //accesseurs du pseudo
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    //accesseurs de la famille préférée
    public String getFamillePref() {
        return famillePref;
    }

    public void setFamillePref(String famillePref) {
        this.famillePref = famillePref;
    }
    
    //accesseurs du paquet
    public LesPersonnages getPaquet() {
        return paquet;
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;
    }
    
    //accesseurs de la photo
    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    //constructeur avec 2 paramètres : le pseudo et la famille préférée
    public Joueur(String pseudo, String famillePref){
        this.pseudo=pseudo;
        this.famillePref=famillePref;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
        this.paquet = new LesPersonnages();
    }
    
    //constructeur par défaut
    public Joueur(){
        this.pseudo = "anonyme";
        this.famillePref = "anonyme";
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    
    public String toString(){
        return "Pseudo :"+getPseudo()+
                "\nFamille préférée : "+getFamillePref()+
                "\nEn possession des personnages : \n"+getPaquet()+
                "\nScore : "+getScore();
    }
    
    //Méthode pour récupérer le score total du paquet du joueur
    public int getScore(){
       return this.paquet.getScore(); //utilisation de la méthode getScore() de la classe LesPersonnages qui renvoie le score total du paquet
    }
    
    //Méthode pour ajouter un personnage au paquet du joueur
    public void ajoutePersoPaquet(Personnage p){
        this.paquet.ajoutePerso(p); //utilisation de la méthode ajoutePerso(p) de la classe LesPersonnages qui ajoute à la liste le personnage passé en paramètre
    }
    
    //Méthode pour tester la classe VisuPersonnagesDlg, qui permet d'ajouter des personnages au paquet d'un joueur
    public void initPaquetTest(){
        ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }

}
