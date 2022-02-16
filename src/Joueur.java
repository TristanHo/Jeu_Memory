
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
    private String pseudo;
    private String famillePref;
    private LesPersonnages paquet;
    private ImageIcon photo;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFamillePref() {
        return famillePref;
    }

    public void setFamillePref(String famillePref) {
        this.famillePref = famillePref;
    }

    public LesPersonnages getPaquet() {
        return paquet;
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
   
    public Joueur(String pseudo, String famillePref){
        this.pseudo=pseudo;
        this.famillePref=famillePref;
        this.photo = new ImageIcon();
        this.paquet = new LesPersonnages();
    }
    
    public String toString(){
        return "Pseudo :"+getPseudo()+
                "\nFamille préférée : "+getFamillePref()+
                "\nEn possession des personnages : "+getPaquet()+
                "\nScore : "+getScore();
    }
    
    public int getScore(){
       return this.paquet.getScore();
    }
}
