package tcp4;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Cliente{
    
    private String nombre;
    private BufferedReader ent;
    private PrintWriter sal;
    
    public Cliente(int id, BufferedReader i, PrintWriter o){
        nombre="Cliente_"+id;
        ent=i;
        sal=o;
    }
    
    public String getNombre(){
        return nombre;
    }
    public BufferedReader getEnt(){
        return ent;
    }
    public PrintWriter getSal(){
        return sal;
    }
}