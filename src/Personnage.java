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
    private String famille;
    private String nom;
    private int valeur;
    private Image photo;
    
    public Personnage(){
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur = 0;
        this.photo = new ImageIcon(getClass().getResource("/memory/img/anonyme.png")).getImage();
    }
    public Personnage(String famille, String nom, int valeur, Image photo){
        this.famille = famille;
        this.nom = nom;
        this.valeur = valeur;
        this.photo = new ImageIcon(getClass().getResource("/memory/img/"+nom+".png")).getImage();
    }
    
    public Personnage(String famille, String nom, int valeur){
        this.famille = famille;
        this.nom = nom;
        this.valeur = valeur;
    }

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
    
    public void setPhoto(String n){
        this.photo = new ImageIcon(getClass().getResource("/memory/img/"+n+".jpg")).getImage();
    }
    
    public String toString(){
        String s = "";
        s = this.nom+" de la famille "+this.famille+", valeur: "+this.valeur;
        return s;
    }
    
}
