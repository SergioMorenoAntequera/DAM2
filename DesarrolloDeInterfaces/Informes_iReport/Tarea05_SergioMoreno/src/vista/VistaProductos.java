/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author seran
 */
public class VistaProductos extends javax.swing.JFrame {

    /**
     * Creates new form VustaProductos
     */
    public VistaProductos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDescuento = new javax.swing.JTextField();
        Precio = new javax.swing.JLabel();
        tfReferencia = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfDescripcion = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Referencia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 82, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 124, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripcion:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 166, -1, -1));

        tfDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescuentoActionPerformed(evt);
            }
        });
        getContentPane().add(tfDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 246, 101, -1));

        Precio.setForeground(new java.awt.Color(0, 0, 0));
        Precio.setText("Precio:");
        getContentPane().add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 208, -1, -1));

        tfReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfReferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(tfReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 78, 101, -1));

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 120, 101, -1));

        tfDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(tfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 162, 101, -1));

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(bGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 301, -1, -1));

        bModificar.setText("Modificar");
        getContentPane().add(bModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 301, -1, -1));

        bEliminar.setText("Eliminar");
        getContentPane().add(bEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 301, -1, -1));

        bLimpiar.setText("Limpiar campos");
        getContentPane().add(bLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 339, -1, -1));

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(bBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 301, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Descuento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 250, -1, -1));

        tfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(tfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 204, 101, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Productos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondoPapel.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescuentoActionPerformed

    private void tfReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfReferenciaActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescripcionActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarActionPerformed

    private void tfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecioActionPerformed

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
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Precio;
    public javax.swing.JButton bBuscar;
    public javax.swing.JButton bEliminar;
    public javax.swing.JButton bGuardar;
    public javax.swing.JButton bLimpiar;
    public javax.swing.JButton bModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField tfDescripcion;
    public javax.swing.JTextField tfDescuento;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfPrecio;
    public javax.swing.JTextField tfReferencia;
    // End of variables declaration//GEN-END:variables
}
