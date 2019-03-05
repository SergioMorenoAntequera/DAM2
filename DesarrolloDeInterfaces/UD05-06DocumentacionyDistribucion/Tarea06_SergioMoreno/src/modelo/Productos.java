/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Plantilla para la creacion de Objetos de este tipo
 * @author seran
 */
public class Productos {
    
    private String referencia;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;

    //--------------------------------------------------------------------------
    
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    //--------------------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //--------------------------------------------------------------------------
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //--------------------------------------------------------------------------

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //--------------------------------------------------------------------------

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
    
    
    
}
