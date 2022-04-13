/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author thoar
 */
public class Personnage {
    
    //déclaration des attributs de la classe
    private String famille;
    private String nom;
    private int valeur;
    private Image photo;
    
    //constructeur par défaut de la classe
    public Personnage(){
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur = 0;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();
    }
    
    //constructeur avec 3 paramètres : la famille, le nom et la valeur du personnage
    public Personnage(String famille, String nom, int valeur){
        this.famille = famille;
        this.nom = nom;
        this.valeur = valeur;
        this.photo = new ImageIcon(getClass().getResource("/img/"+nom+".jpg")).getImage();
    }
    
    //Accesseurs des attributs
    public String getFamille() {
        return famille;
    }

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String toString(){
        String s = "";
        s = this.nom+" de la famille "+this.famille+", valeur: "+this.valeur;
        return s;
    }
    
    //Méthode pour appliquer sur un bouton la photo du personnage, en prenant en compte les dimensions du bouton
    public void setImgBouton(JButton jb) {
        Image img = photo.getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        jb.setIcon(new ImageIcon(img));
    }


}
