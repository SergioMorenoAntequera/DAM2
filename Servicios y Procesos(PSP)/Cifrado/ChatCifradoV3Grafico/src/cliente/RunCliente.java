/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cifrado.Cifrar;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author seran
 */
public class RunCliente {
   
    static InetAddress direccionIP = null;
    static int puerto = 0;
        
    static VistaConectar vConectar;
    static VistaChat vChat;
    
    static BufferedReader flujoEntrada = null;
    static PrintWriter flujoSalida = null;
    
    //--------------------------------------------------------------------------
    
    public static void main(String[] args) {
        
        vConectar = new VistaConectar();
        vConectar.setVisible(true);

        vConectar.bConectar.addActionListener(new ActionListener() {

            //Convertimos los paramatros para ver si son validos
            @Override
            public void actionPerformed(ActionEvent e) {

                //Convertimos la dirección a formato InetAdress y el puerto a int
                try {
                    direccionIP = InetAddress.getByName(vConectar.tfDireccionIP.getText());
                    puerto = Integer.parseInt(vConectar.tfPuerto.getText());                 
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de Dirreción IP Errorneo o Desconocido");
                    System.exit(0);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato Puerto Erroneo!");
                    System.exit(0);
                }

                //--------------------------------------------------------------
                
                //Establecemos la conexion y conseguimos los flujos
                try (
                        Socket con = new Socket(direccionIP, puerto);
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        PrintWriter out = new PrintWriter(con.getOutputStream(), true);
                ) {
                    flujoEntrada = in;
                    flujoSalida = out;
                                     
                    //Como ultimos lanzaremos la proxima ventana
                    vChat = new VistaChat();
                    vChat.setLocationRelativeTo(null);
                    vChat.setVisible(true);
                    vConectar.setVisible(false);
                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Imposible conectar con el servidor");
                    System.exit(0);
                }
            }
        });

        /*EscribirCliente hElClienteEscribe = new EscribirCliente(flujoSalida);
         hElClienteEscribe.start();*/
        
        //----------------------------------------------------------
        /*
            vChat.bEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensajeAEnviar = vChat.tfMsgAEnviar.getText();
                Cifrar cifrar = new Cifrar(mensajeAEnviar);
                String mensajeAEnviarCifrado = cifrar.getFraseCifrada();

                flujoSalida.println(mensajeAEnviarCifrado);
                vChat.taChat.append("[ Yo ]> " + mensajeAEnviar + "\n");
            }
        });

        //----------------------------------------------------------------------
        
        /*LeerCliente hLeerCliente = new LeerCliente(flujoEntrada, vChat.taChat);
         hLeerCliente.start();
                    
         //La siguiente parte pone al cliente en escucha de lo que diga el server
         while (true) {
         String mensajeRecibido = flujoEntrada.readLine();
         vChat.taChat.append(mensajeRecibido);
         }*/
    }
}
