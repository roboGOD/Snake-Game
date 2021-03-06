/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakePack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roboGOD
 */

class Score implements Serializable, Comparable<Score> {
    private final String name;
    private final int score;
    
    Score(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    String getName() {
        return this.name;
    }
    
    int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Score o) {
        int compRes = -Integer.compare(this.score, o.score);
        return ((compRes == 0) ? this.getName().compareTo(o.getName()) : compRes);
    }
}

final class ManageScores {
    static final String filename = "scores.dat";
    
    void writeScores(TreeSet<Score> sc) {
        try {
            FileOutputStream f = new FileOutputStream(getClass().getResource("/SnakePack/"+filename).toString().substring(5));
            ObjectOutputStream of = new ObjectOutputStream(f);
            of.writeObject(sc);
            of.close();
        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    TreeSet<Score> readScores() {
        TreeSet<Score> sc = null;
        try {
            FileInputStream f = new FileInputStream(getClass().getResource("/SnakePack/"+filename).toString().substring(5));
            ObjectInputStream of = new ObjectInputStream(f);
            sc = (TreeSet<Score>)of.readObject();
            of.close();
        }
        catch(ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
        return sc;
    }
    
    // Executed for the first time only.
     private void writeFirstTime() {
        TreeSet<Score> scores = new TreeSet<>();
        scores.add(new Score("roboGOD", 2000));
        scores.add(new Score("Joker", 40));
        scores.add(new Score("VRock", 50));
        scores.add(new Score("Sahi", 30));
        scores.add(new Score("Jora", 30));
        scores.add(new Score("IITian", 20));
        scores.add(new Score("2 Thru 3", 00));
        scores.add(new Score("NA", 00));
        scores.add(new Score("Google", 00));
        scores.add(new Score("Beta Beta", 00));
        writeScores(scores);
    }
}

public class HighScores extends javax.swing.JFrame {

    /**
     * Creates new form HighScores
     */
    
    ManageScores m;
    
    public HighScores() {
        initComponents();
        init();
    }
    
    final void init() {
        setLocationRelativeTo(null);
        m = new ManageScores();
        TreeSet<Score> sc = m.readScores();
        displayTable(sc);
        setTitle("High Scores");
        pack();
        setVisible(false);
        setVisible(true);
    }
    
    void displayTable(TreeSet<Score> sc) {
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        
        String header[] = new String[] {"#", "Name", "Score"};
        dtm.setColumnIdentifiers(header);
        
        int id=1;
        for(Score s: sc) {
            dtm.addRow(new Object[]{id, s.getName(), s.getScore()});
            id++;
            System.out.println(s.getName() + " " + String.valueOf(s.getScore()));
        }
        
        jTable2.setModel(dtm);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(40);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 467, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
