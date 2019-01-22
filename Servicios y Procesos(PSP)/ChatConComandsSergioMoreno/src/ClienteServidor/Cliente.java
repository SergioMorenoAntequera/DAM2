/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author windiurno
 */
public class Cliente {
    
    private int idCli;
    private String nomCli;
    private BufferedReader entrada;
    private PrintWriter salida;
    private ArrayList<Cliente> baneados;
    private boolean baneado;
    
    //--------------------------------------------------------------------------
    
    public Cliente(int id, BufferedReader br, PrintWriter pw){
        idCli=id;
        entrada=br;
        salida=pw;
        baneados = new ArrayList<Cliente>();
        ponNombre();
    }
    
    //--------------------------------------------------------------------------
    
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
    public ArrayList<Cliente> getBaneados() {
        return baneados;
    }
    public void setBaneados(ArrayList<Cliente> baneados) {
        this.baneados = baneados;
    }
    public boolean isBaneado() {
        return baneado;
    }
    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }
}
