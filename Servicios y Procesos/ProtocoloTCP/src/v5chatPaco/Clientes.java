/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v5chatPaco;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class Clientes {
    private int idCli;
    private String nomCli;
    private BufferedReader entrada;
    private PrintWriter salida;
    private ArrayList<Clientes> baneados;
    
    public Clientes(int id, BufferedReader br, PrintWriter pw){
        idCli=id;
        entrada=br;
        salida=pw;
        baneados = new ArrayList<Clientes>();
        ponNombre();
    }
    public void ponNombre(){
            nomCli="Cliente_"+idCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public PrintWriter getSalida() {
        return salida;
    }

    public ArrayList<Clientes> getBaneados() {
        return baneados;
    }

    public void setBaneados(ArrayList<Clientes> baneados) {
        this.baneados = baneados;
    }
    
    
}
