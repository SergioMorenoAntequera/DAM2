package vista;
import cifrado.Cifrar;
import cliente.LeerCliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaChat extends javax.swing.JFrame {

    static Socket conexion;
    static Cifrar cifrar;
    static String mensajeAEnviar;
    static PrintWriter flujoSalida;
    static BufferedReader flujoEntrada;
    
    ActionEvent evt2;
    
    /**
     * Creates new form ChatCliente
     */
    public VistaChat(Socket conexion) {
        initComponents();
        this.getContentPane().setBackground(new Color(63, 150, 172));
        this.setLocationRelativeTo(null);
        
        this.conexion = conexion;
        
        try {
            flujoEntrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            
            LeerCliente hLeerCliente = new LeerCliente(flujoEntrada, taChat);
            hLeerCliente.start();
            
        } catch (IOException ex) {
            Logger.getLogger(VistaChat.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taChat = new javax.swing.JTextArea();
        tfMsgAEnviar = new javax.swing.JTextField();
        bEnviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("*** Chat TCP Multicliente ***");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 251, -1));

        taChat.setBackground(new java.awt.Color(0, 0, 0));
        taChat.setColumns(20);
        taChat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        taChat.setForeground(new java.awt.Color(0, 255, 51));
        taChat.setLineWrap(true);
        taChat.setRows(5);
        taChat.setEditable(false);
        taChat.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(taChat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 69, 347, 244));

        tfMsgAEnviar.setBackground(new java.awt.Color(0, 0, 0));
        tfMsgAEnviar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tfMsgAEnviar.setForeground(new java.awt.Color(0, 255, 0));
        tfMsgAEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMsgAEnviarKeyTyped(evt);
            }
        });
        getContentPane().add(tfMsgAEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 327, 276, -1));

        bEnviar.setText("Enviar");
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(bEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 325, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/131306.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
        
        try {
            flujoSalida = new PrintWriter(conexion.getOutputStream(), true);
            mensajeAEnviar = tfMsgAEnviar.getText();
            
            
            cifrar = new Cifrar(mensajeAEnviar);
            flujoSalida.println(cifrar.getFraseCifrada());
            
            tfMsgAEnviar.setText("");
            taChat.append("[Yo]> " + mensajeAEnviar + "\n");
        } catch (IOException ex) {
            Logger.getLogger(VistaChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        taChat.setCaretPosition(taChat.getDocument().getLength()); //Scroll automatico
    }//GEN-LAST:event_bEnviarActionPerformed

    private void tfMsgAEnviarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMsgAEnviarKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            bEnviar.doClick();
        }
    }//GEN-LAST:event_tfMsgAEnviarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea taChat;
    public javax.swing.JTextField tfMsgAEnviar;
    // End of variables declaration//GEN-END:variables
}
