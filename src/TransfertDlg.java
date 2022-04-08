
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author Aorus
 */
public class TransfertDlg extends javax.swing.JDialog {

    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant
    private Transfert tc; //attribut pour gérer le transfert
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné
    
    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int indj) {
        super(parent, modal);
        initComponents();
        //La boîte de dialogue reçoit la liste des joueurs de la partie et l'indice dans cette liste du joueur courant
        //La boîte de dialogue doit renvoyer les nouveaux paquets des joueurs qui ont été modifiés, le booléen 
        this.lj = lj; //ensemble des joueurs de la partie
        this.indj = indj ; //indice du joueur courant
        // this.tc=null;
        this.ok=false; //booléen pour savoir si il y a eu un transfert de cartes
        this.fs=null;
        initCombo(); // méthode pour remplir la liste déroulante
        this.indjs = 0; //indice du joueur sélectionné dans la JComboBox
        Message1.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
    }
    
    //Accesseurs du booléen 
    public boolean getOk(){
        return this.ok;
    }
    
    public void setOk(boolean bool){
        this.ok = bool;
    }
    
    public Transfert getTc(){
        return this.tc;
    }
    
    public void setTc(Transfert t){
        this.tc = t;
    }
    
    //Remplissage de la JComboBox avec le nom des Joueurs
    public void initCombo(){
        for(int i=0;i<this.lj.getNbJoueurs();i++)
            ComboJoueurs.addItem(this.lj.getJoueur(i).getPseudo());
    }
    
    //Permet de définir la stratégie du panneau et de lui ajouter les boutons nécessaires
    //pour afficher les personnages
    public void initPanneau(){
        PanneauG.removeAll(); //on retire tous les éléments du panneau
        this.repaint(); //on le réaffiche
        LesPersonnages lcs = this.lj.getJoueur(indj).getPaquet(); //stockage du paquet du joueur sélectionné dans une variable
        int t = lcs.getTaille(); //nombre de personnages dans le paquet
        int n = 1+(t-1)/4; //nombre de colonnes pour les boutons à afficher
        PanneauG.setLayout(new java.awt.GridLayout(4,n)); //on applique le Layout correspondant au panneau
        for(int i = 0; i < t; i++){
            JButton b = new JButton(); //création d'un bouton
            b.setName(lcs.getPerso(i).getFamille()); //on affecte comme nom au bouton la famille du personnage
            //Abonnement du bouton à un écouteur d'événement
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    boutonActionPerformed(evt);
                }
            });
            PanneauG.add(b); //ajout du bouton au panneau
        }
        this.pack();
    }
    
    //Evenement exécuté en cas de clc sur un bouton du panneau
    private void boutonActionPerformed(ActionEvent evt){
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet(); //récupération du paquet du joueur sélectionné
        int t = lp.getTaille(); //nombre de personnages du paquet
        JButton bt=(JButton) evt.getSource(); //récupération du bouton où l'événement a eu lieu
        fs = bt.getName(); // la propriété Name, contient ici le nom du personnage affiché sur le bouton
        for(int i = 0; i < t; i++) {
            JButton b = (JButton)(PanneauG.getComponent(i)); //récupération du ième bouton du panneau
            //si le nom du bouton correspond à la famille c'est-à-dire au nom du bouton sélectionné
            //cela signifie que les deux boutons correspondent à des personnages de la même famille
            //On affiche donc une bordure rouge sur ce bouton
            if (b.getName().equals(fs)) 
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
            //sinon on ne fait rien
            else
                b.setBorder(null);
            }
        LesPersonnages lps = lp.getPersosFamille(fs); //récupération des personnages du paquet correspondant à la même famille
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps); //affichage du nombre de personnages de la même famille récupérables
    }
    
    //Permet d'appliquer les photos des personnages sur les boutons du panneau
    private void affichePanneau(){
        LesPersonnages lcs = this.lj.getJoueur(indjs).getPaquet(); //récupération du paquet du joueur sélectionné
        for(int i =0; i<lcs.getTaille();i++){ 
            JButton b = (JButton)PanneauG.getComponent(i); //récupération du ième bouton du panneau
            lcs.getPerso(i).setImgBouton(b); //on lui applique la photo du personnage correspondant
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Message1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        PanneauG.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauG);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        Message1.setText("jLabel1");
        jPanel2.add(Message1);

        jLabel2.setText("jLabel1");
        jPanel2.add(jLabel2);

        jLabel3.setText("jLabel1");
        jPanel2.add(jLabel3);

        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel2.add(ComboJoueurs);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        Transfert.setText("Transfert");
        jPanel4.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel4.add(Fermer);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1);

        PanneauD.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
        this.indjs = ComboJoueurs.getSelectedIndex(); //récupération de l'indice de l'élément sélectionné dans la JComboBox
        if (indjs != -1){ //on vérifie qu'un élément est bien sélectionné
            if(this.indjs == this.indj){ //si l'indice est le même que celui du joueur courant
                Infos.setText("Sélectionnez un joueur différent du joueur courant !"); //on indique qu'il faut sélectionner un autre joueur
                PanneauG.removeAll(); //on enlève tous les composants du panneau
                PanneauG.repaint(); //on réaffiche le panneau
            }
            else { //si c'est un autre joueur que le joueur courant qui est sélectionné
                Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString()); //On affiche les informations du joueur
                //Appel de ces deux méthodes pour remplir le tableau de gauche avec les personnages du joueur sélectionné
                initPanneau();
                affichePanneau();
            }
        }
    }//GEN-LAST:event_ComboJoueursActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_FermerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true, null, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message1;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
