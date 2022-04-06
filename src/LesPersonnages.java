/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoar
 */


import java.util.ArrayList;

public class LesPersonnages {
    
    //déclaration de l'attribut de la classe, une ArrayListe contenant des éléments de type Personnage
    private ArrayList<Personnage> persos;
    
    //Accesseur de l'attribut
    public ArrayList<Personnage> getPersos() {
        return this.persos;
    }
    
    //constructeur par défaut 
    public LesPersonnages() {
      this.persos = new ArrayList<Personnage>();
     }
    
    //Récupérer le nombre de personnages dans la liste
    public int getTaille() { 
         return this.persos.size(); //le nombre de personnages équivaut à la taille de la liste
     }
    
    //Récupérer le score total de la liste de personnages
    public int getScore(){   
        int sc = 0; //on initialise une variable qui contiendra le score final
        //on parcourt la liste et on ajoute à cette variable le score de chaque personnage
        for(int i=0; i<getTaille(); i++)
           sc+=getPerso(i).getValeur();
        return sc;
    }
    
    //Récupérer un personnage de la liste grâce à son indice
    public Personnage getPerso(int i){
        if (i>=0 && i<this.persos.size()) //on vérifie que l'indice passé en paramètre est bien compris entre 0 (inclus) et la taille de la liste
             return this.persos.get(i); //si c'est le cas, on récupère l'élément d'indice i dans la liste grâce la méthode get(i) et on renvoie cet élément
        else return null; //dans le cas contraire, on renvoie null, c'est-à-dire qu'aucun personnage n'a été trouvé avec l'indice passé en paramètre
    }
    
    //Récupérer une liste des personnages de la famille dont le nom est passé en paramètre
    public LesPersonnages getPersosFamille(String f)
    {   LesPersonnages lp = new LesPersonnages(); //déclaration d'une variable de type LesPersonnages qui contiendra l'ensemble des personnages ayant la famille recherchée
        for(int i=0; i<getTaille(); i++) //on parcourt la liste contenant les personnages
            if(getPerso(i).getFamille().equals(f))
                lp.ajoutePerso(getPerso(i)); //si la famille du personnage est la même que la chaîne passée en paramètre, on ajoute ce personnage à la variable lp
        return lp;
    }
    
    //Retirer de la liste un personnage passé en paramètre 
    public void retirePerso(Personnage p)
    { 
        int i=0; //déclaration d'un entier pour parcourir la liste de personnages
        boolean trouve = false; //déclaration d'un booléen, pour sortir de la boucle while lorsque le personnage a été retiré
        while(i<getTaille() && !trouve){ //tant que l'entier n'a pas dépassé la taille de la liste et que le personnage n'a pas été retiré
          if (getPerso(i).getNom().equals(p.getNom())){
              this.persos.remove(getPerso(i));  //si le nom du personnage d'indice i de la liste est égal au nom du personnage passé en paramètre, on retire ce personnage de la liste
              trouve = true; //on passe le booléen à true, ce qui veut dire qu'on a trouvé le personnage et qu'on sort de la boucle while
          }
          else i++; //sinon, on incrémente l'indice pour continuer à parcourir la liste
        }      
    }
    
    //Récupérer les personnages de la liste jusqu'au n-ième, en les retirant de la liste
    public LesPersonnages retirePersos(int n)
    { LesPersonnages lcr = new LesPersonnages(); //variable de type LesPersonnages qui contiendra les personnages retirés
        for (int i=0; i<=n; i++)
        {
            lcr.ajoutePerso(getPerso(0)); //ajout à la variable du premier personnage de la liste
            this.persos.remove(getPerso(0));  //on retire le personnage de la liste actuelle
        }
        return lcr;
    } 
    
    //Idem que retirePersos, sauf qu'on ne prend que les personnages dont la famille correspond à celle passée en paramètre
    public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(getPerso(i));  
            }
            else i++;
        }
        return lcr;
    }
    
    //Retirer tous les personnages de la liste
    public void retireCartes()
    { 
        this.persos.clear();
    }
    
	@Override
    public String toString() {
        String s = "";
        for(int i=0; i<getTaille(); i++)
            s+=i+"- "+getPerso(i).toString()+"\n";
       return s;
    }
    
    //Ajouter un personnage à la liste
    public void ajoutePerso(Personnage p){
        this.persos.add(p);
    }
    
    //Ajouter des personnages à la liste
    public void ajoutePersos(LesPersonnages lp){
        for(int i=0;i<lp.getTaille();i++)
            this.persos.add(lp.getPerso(i));
    }
    
    //Constructeur de la classe prenant en paramètre un entier
    public LesPersonnages(int nc) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
}
