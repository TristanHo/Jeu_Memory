/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author unknown
 */
public class PlateauJeu {
    
    //déclaration des attributs de la classe
    private int tab [ ][ ];
    private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
    private int nblig;
    private int nbcol;
    
    //constructeur de la classe ayant commme paramètre un entier
    public PlateauJeu(int n){ 
        this. nbp=n;
        this.nblig=(int)(Math.sqrt(nbp*2)) ;
        this.nbcol=nbp*2/nblig;
        this.tab=new int [this.nblig][this.nbcol];
        initPlateauJeu();
    }

    public PlateauJeu() 
    {
        this(4);
    }
    
    //Accesseurs des attributs
    public int getNblig() { return this.nblig; }
    public int getNbcol() { return this.nbcol; }
    public int getNbp() { return this.nbp; }
    
    //Récupérer la valeur dans une case du tableau
    public int getCase(int l, int c) { return tab[l][c]; }
    
    //Récupérer le nombre de cases (nombre de personnages)
    public int getNbc() { return this.nblig*this.nbcol/2; }
    
    //Initialiser chaque case du plateau
    public void initPlateauJeu(){ 
        int k=0;
        for(int i=0; i<this.nblig; i++)
            for(int j=0; j<this.nbcol; j++)
                tab[i][j]=(k++)%this.nbp; //on numérote de 0 jusqu'au nombre de persos les cases
        
        this.melange();
    }
    
    //Invalider les deux cases quand le joueur a trouvé les deux personnages
    public void invalide(int l1, int c1, int l2, int c2){
        //Si le joueur a trouvé les deux persos, on donne comme valeur au case -1, ce qui signifie qu'il n'y a plus de perso
        tab[l1][c1]=-1;
        tab[l2][c2]=-1;
        nbp--; //on réduit de 1 le nombre de personnages encore sur le plateau
    }
    
    //1000 permutations de cases 2 par 2 dans le plateau
    public void melange(){
        int i1;
        int j1;
        int i2;
        int j2;
        for(int i = 0; i < 1000; i++){ //on répète le mélange 1000 fois
            
            //ligne et colonne de la première case choisies aléatoirement
             i1= (int)(Math.random() * nblig);
             j1= (int)(Math.random() * nbcol);
            //ligne et colonne de la seconde case choisies aléatoirement
             i2 = (int)(Math.random() * nblig);
             j2 = (int)(Math.random() * nbcol);
            
            int temps = tab[i1][j1]; //On déclare une variable qui va nous servir temporairement pour faire un transfert de valeurs et pour ne pas perdre de données
            
            //On permute
            tab[i1][j1] = tab[i2][j2]; 
            tab[i2][j2] = temps; 
        }
    }

    //Vérifier si le jeu est vide
    public boolean jeuVide(){
        return this.nbp==0; //si le jeu est vide (0 personnages), cette méthode renvoie true
    }
    
    //Vérifier qu'une case est valide (contient un personnage)
    public boolean estValide(int l, int c){
        //on vérifie si la case est bien numérotée, c'est-à-dire qu'elle contient un perso
        return tab[l][c]!=-1;
    }

    //Mettre fin au jeu
    public void termineJeu(){ 
        //si le jeu est terminé, toutes les cases prennent comme valeur -1 (case vide)
        for(int i =0; i< this.nblig;i++)
        {
            for (int j = 0; j < this.nbcol; j++) 
            {
                this.tab[i][j]=-1;
            }
        }
        nbp=0; //on met le nombre de personnage à 0
    }
}