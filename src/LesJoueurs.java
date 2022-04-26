/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoar
 */
import java.util.*;
public class LesJoueurs {
    
    //déclaration de l'attribut de la classe, une ArrayList contenant des éléments de type Joueur
    private ArrayList<Joueur> lstJ;
    
    //constructeur par défaut
    public LesJoueurs(){
        this.lstJ = new ArrayList<Joueur>(); //appel du constructeur par défaut de ArrayList pour initialiser l'attribut
    }
    
    //Récupérer un joueur de la liste grâce à son indice
    public Joueur getJoueur(int i){
        if(i < lstJ.size() && i>-1) //on vérifie que l'indice passé en paramètre est bien compris entre 0 (inclus) et la taille de la liste
            return lstJ.get(i); //si c'est le cas, on récupère l'élément d'indice i dans la liste grâce la méthode get(i) et on renvoie cet élément
        else
            return null; //dans le cas contraire, on renvoie null, c'est-à-dire qu'aucun joueur n'a été trouvé avec l'indice passé en paramètre
    }
    
    //Récupérer l'indice dans la liste d'un joueur passé en paramètre
    public int getIndiceJoueur(Joueur j){
        return(lstJ.indexOf(j)); //on utilise la méthode indexOf() qui renvoie l'indice dans la liste de l'élément passé en paramètre
    }
    
    //Récupérer le nombre de joueurs dans la liste
    public int getNbJoueurs(){
        return this.lstJ.size(); //le nombre de joueurs équivaut à la taille de la liste
    }
    
    //Ajouter un joueur à la liste 
    public void ajouteJoueur(Joueur j){
        this.lstJ.add(j); //utilisation de la méthode add() qui ajoute l'élément passé en paramètre à la liste
    }
    
    //Ajouter les joueurs d'une liste de joueurs passé en paramètre à la liste actuelle
    public void ajouteJoueurs(LesJoueurs j){
        for(int i=0;i<j.getNbJoueurs();i++){ //on parcourt la liste passée en paramètre grâce à la boucle for
            this.ajouteJoueur(j.getJoueur(i)); //on récupère le joueur à l'indice i de la liste passée en paramètre afin de pouvoir l'ajouter à la liste actuelle grâce à la méthode ajouteJoueur qui prend un joueur en paramètre
        }
    }
    
    //Récupérer un joueur grâce à son pseudo
    public Joueur rechJoueur(String p){
        Joueur j = null; //déclaration d'une variable de type joueur
        for(int i=0;i<getNbJoueurs();i++){ //on parcourt la liste
            if(lstJ.get(i).getPseudo().equals(p)) 
                j = lstJ.get(i); //si le pseudo du joueur d'indice i dans la liste est égal à celui passé en paramètre, on affecte ce joueur à la variable j et on sort de la boucle
        }
        return j;
    }
    
    //Supprimer de la liste le joueur passé en paramètre
    public void supprimeJoueur(Joueur j){
        lstJ.remove(getIndiceJoueur(j)); //Nous recherchons l'indice du joueur à supprimer grâce à la méthode getIndiceJoueur() puis nous le supprimons de la liste grâce à la méthode remove() qui prend l'indice de l'élément à supprimer en paramètre
    }

    public String toString() {
        String s = "";
        for(int i =0;i<lstJ.size();i++){
            s += "\n\n"+lstJ.get(i).toString();
        }
        return s;
    }
    
    //Récupération des joueurs donc le score est le plus haut
    public LesJoueurs getGagnants(){
        int max= getJoueur(0).getScore(); //on assigne comme max le score du premier joueur de la liste
        for(int i=1; i<getNbJoueurs();i++) //on parcourt la liste des joueurs
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore(); //si un joueur a un score supérieur au max fixé, alors le max prend cette nouvelle valeur
        LesJoueurs lst=new LesJoueurs(); //déclaration d'une variable de type LesJoueurs
        //on parcourt la liste des joueurs et on ajoute à la variable lst l'ensemble des joueurs donc le score est égal au max, c'est-à-dire les gagnants
        for(int i=0; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()==max)
                lst.ajouteJoueur(getJoueur(i));
        return lst; //on renvoie la liste des gagnants
    }
}
