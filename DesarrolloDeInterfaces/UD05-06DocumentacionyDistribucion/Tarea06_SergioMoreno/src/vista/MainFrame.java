/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 * Frame crado con una interfaz grafica de NetBeans para la ventana principal.
 * @author seran
 */
public class MainFrame extends javax.swing.JFrame {

    public URL hsURL;
    public HelpSet helpset;
    public HelpBroker hb;
             
    /**
     * Creates new form mainFrame
     */
    public MainFrame() {
        initComponents();
        
        File fichero = new File("src/help/help_set.hs");
        try {
            hsURL = fichero.toURI().toURL();

            // Crea el HelpSet
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            
        } catch (HelpSetException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        bEj02 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bProductos = new javax.swing.JButton();
        bVehiculos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        ejercicio02 = new javax.swing.JMenu();
        miProductos = new javax.swing.JMenuItem();
        miVehiculos = new javax.swing.JMenuItem();
        ejercicio03 = new javax.swing.JMenu();
        jmInformes = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemAyuda = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tarea Obligatoria del T5: Informes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 36, -1, -1));

        bEj02.setText("Informes");
        getContentPane().add(bEj02, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 146, 130, 76));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ejercicio 03");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 111, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ejercicio 02");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 111, -1, -1));

        bProductos.setText("Productos");
        bProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProductosActionPerformed(evt);
            }
        });
        getContentPane().add(bProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 168, -1, -1));

        bVehiculos.setText("Vehiculos");
        getContentPane().add(bVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 168, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondoPapel.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 310));

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        ejercicio02.setText("Ejercicio02");

        miProductos.setText("Productos");
        miProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductosActionPerformed(evt);
            }
        });
        ejercicio02.add(miProductos);

        miVehiculos.setText("Vehiculos");
        ejercicio02.add(miVehiculos);

        menuBar.add(ejercicio02);

        ejercicio03.setText("Ejercicio03");

        jmInformes.setText("Informes");
        ejercicio03.add(jmInformes);

        menuBar.add(ejercicio03);

        jMenu1.setText("Ayuda");

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemAyuda.setText("Mostrar Ayuda");
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        jMenu1.add(itemAyuda);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProductosActionPerformed
          
    }//GEN-LAST:event_bProductosActionPerformed

    private void miProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miProductosActionPerformed

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        hb.enableHelpOnButton(itemAyuda, "ventana_principal", helpset);
    }//GEN-LAST:event_itemAyudaActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bEj02;
    public javax.swing.JButton bProductos;
    public javax.swing.JButton bVehiculos;
    public javax.swing.JMenu ejercicio02;
    public javax.swing.JMenu ejercicio03;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jmInformes;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenuItem miProductos;
    public javax.swing.JMenuItem miVehiculos;
    // End of variables declaration//GEN-END:variables
}
