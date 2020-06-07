package personaltrainer.Form;
import java.util.ArrayList;
import personaltrainer.Class.Cliente;
import personaltrainer.Class.Treino;
import personaltrainer.Class.TreinoGrupo;
import personaltrainer.Class.TreinoIndividual;
import personaltrainer.Report.FormReports; 
/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public class FormMenu extends javax.swing.JFrame {
 ArrayList <Treino> treino  = new ArrayList(); 
 ArrayList <Cliente> cliente  = new ArrayList();
 
    public FormMenu() {
        initComponents();
        diretoCodigo();
    }
  
     public void diretoCodigo(){
        cliente.add(new Cliente("22222222","Fabiano","63925656"));
        cliente.add(new Cliente("33333333","Jackson","63925656"));
        cliente.add(new Cliente("44444444","Carlos","63925656"));
        cliente.add(new Cliente("55555555","Madia","63925656")); 
        cliente.add(new Cliente("66666666","Maria","63925656"));
        cliente.add(new Cliente("77777777","Cristina","63925656"));
        cliente.add(new Cliente("88888888","Parcilene","63925656")); 
        treino.add(new TreinoIndividual(cliente.get(0),1,"A","18h",80.0));
        treino.add(new TreinoIndividual(cliente.get(1),2,"B","7h",60.0));
        treino.add(new TreinoIndividual(cliente.get(2),3,"A","18h",80.0));
        treino.add(new TreinoGrupo(4,"A","18h",850.0)); 
        treino.add(new TreinoGrupo(5,"B","19h",850.0));  
        treino.get(3).addClientes(cliente.get(0)); 
        treino.get(3).addClientes(cliente.get(1)); 
        treino.get(3).addClientes(cliente.get(2)); 
        treino.get(3).addClientes(cliente.get(3)); 
        treino.get(3).addClientes(cliente.get(4));   
        treino.get(4).addClientes(cliente.get(0)); 
        treino.get(4).addClientes(cliente.get(1)); 
        treino.get(4).addClientes(cliente.get(2)); 
        treino.get(4).addClientes(cliente.get(3)); 
        treino.get(4).addClientes(cliente.get(4));  
      }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaTrab = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout areaTrabLayout = new javax.swing.GroupLayout(areaTrab);
        areaTrab.setLayout(areaTrabLayout);
        areaTrabLayout.setHorizontalGroup(
            areaTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        areaTrabLayout.setVerticalGroup(
            areaTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jMenu1.setText("Inserir");

        jMenuItem1.setText("Treinos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Imprimir");

        jMenuItem3.setText("Reports");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");

        jMenuItem4.setText("Desenv.");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrab)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FormTreinos formtreinos = new FormTreinos(treino, cliente);
        areaTrab.add(formtreinos);
        formtreinos.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FormClientes formclientes = new FormClientes(cliente);
        areaTrab.add(formclientes);
        formclientes.setVisible(true); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FormReports formr = new FormReports(cliente, treino);
        areaTrab.add(formr);
        formr.setVisible(true); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       FormAbout forma = new FormAbout();
       areaTrab.add(forma);
       forma.setVisible(true); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane areaTrab;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
