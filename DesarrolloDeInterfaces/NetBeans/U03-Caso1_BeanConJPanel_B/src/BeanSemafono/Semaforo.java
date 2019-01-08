/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSemafono;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author windiurno
 */
public class Semaforo extends javax.swing.JPanel {

    /**
     * Creates new form Semaforo
     */
    public Semaforo() {
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

        rbSemaforo = new javax.swing.ButtonGroup();
        tfTitutlo = new javax.swing.JTextField();
        rbRojo = new javax.swing.JRadioButton();
        rbAmarillo = new javax.swing.JRadioButton();
        rbVerde = new javax.swing.JRadioButton();
        pColor = new javax.swing.JPanel();

        tfTitutlo.setEditable(false);
        tfTitutlo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfTitutlo.setText("Semáforo");
        tfTitutlo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTitutloActionPerformed(evt);
            }
        });

        rbRojo.setBackground(new java.awt.Color(204, 0, 0));
        rbSemaforo.add(rbRojo);
        rbRojo.setForeground(new java.awt.Color(255, 255, 255));
        rbRojo.setText("Rojo");
        rbRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRojoActionPerformed(evt);
            }
        });

        rbAmarillo.setBackground(new java.awt.Color(204, 204, 0));
        rbSemaforo.add(rbAmarillo);
        rbAmarillo.setForeground(new java.awt.Color(255, 255, 255));
        rbAmarillo.setText("Amarillo");
        rbAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmarilloActionPerformed(evt);
            }
        });

        rbVerde.setBackground(new java.awt.Color(0, 255, 0));
        rbSemaforo.add(rbVerde);
        rbVerde.setForeground(new java.awt.Color(255, 255, 255));
        rbVerde.setText("Verde");
        rbVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVerdeActionPerformed(evt);
            }
        });

        pColor.setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout pColorLayout = new javax.swing.GroupLayout(pColor);
        pColor.setLayout(pColorLayout);
        pColorLayout.setHorizontalGroup(
            pColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        pColorLayout.setVerticalGroup(
            pColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(tfTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbAmarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addComponent(pColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tfTitutlo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbRojo)
                        .addGap(18, 18, 18)
                        .addComponent(rbAmarillo)
                        .addGap(18, 18, 18)
                        .addComponent(rbVerde))
                    .addComponent(pColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfTitutloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTitutloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTitutloActionPerformed

    private void rbRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRojoActionPerformed
        pColor.setBackground(Color.RED);
    }//GEN-LAST:event_rbRojoActionPerformed

    private void rbAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmarilloActionPerformed
        pColor.setBackground(Color.YELLOW);
    }//GEN-LAST:event_rbAmarilloActionPerformed

    private void rbVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVerdeActionPerformed
        pColor.setBackground(Color.GREEN);
    }//GEN-LAST:event_rbVerdeActionPerformed

    public JTextField getjTextField1() {
        return tfTitutlo;
    }
    public void setjTextField1(JTextField jTextField1) {
        this.tfTitutlo = jTextField1;
    }
    public JPanel getpColor() {
        return pColor;
    }
    public void setpColor(JPanel pColor) {
        this.pColor = pColor;
    }
    public JRadioButton getRbAmarillo() {
        return rbAmarillo;
    }
    public void setRbAmarillo(JRadioButton rbAmarillo) {
        this.rbAmarillo = rbAmarillo;
    }
    public JRadioButton getRbRojo() {
        return rbRojo;
    }
    public void setRbRojo(JRadioButton rbRojo) {
        this.rbRojo = rbRojo;
    }
    public ButtonGroup getRbSemaforo() {
        return rbSemaforo;
    }
    public void setRbSemaforo(ButtonGroup rbSemaforo) {
        this.rbSemaforo = rbSemaforo;
    }
    public JRadioButton getRbVerde() {
        return rbVerde;
    }
    public void setRbVerde(JRadioButton rbVerde) {
        this.rbVerde = rbVerde;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pColor;
    private javax.swing.JRadioButton rbAmarillo;
    private javax.swing.JRadioButton rbRojo;
    private javax.swing.ButtonGroup rbSemaforo;
    private javax.swing.JRadioButton rbVerde;
    private javax.swing.JTextField tfTitutlo;
    // End of variables declaration//GEN-END:variables
}
