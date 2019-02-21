/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCasa;

/**
 *
 * @author seran
 */
public class Humano {
    
    String nombre;
    int edad;
    Gato[] gatos;

    //--------------------------------------------------
    
    public Humano(String nombre, int edad, Gato[] gatos) {
        this.nombre = nombre;
        this.edad = edad;
        this.gatos = gatos;
    }

    //--------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Gato[] getGatos() {
        return gatos;
    }

    public void setGatos(Gato[] gatos) {
        this.gatos = gatos;
    }

    @Override
    public String toString() {
        return "Humano{" + "nombre=" + nombre + ", edad=" + edad + ", gatos=" + gatos + '}';
    }
}
