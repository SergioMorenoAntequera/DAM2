/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej05CrearObjetosconXStream;
import ej04CrearXMLconXStream.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seran
 */

@XmlRootElement
public class Departamento implements Serializable {
    
    private String id;
    private String tipo;
    private String nombre;
    private String domicilio;
    private String ciudad;
    private String cp;
    private String provincia;
    private String pais;

    public Departamento(String id, String tipo, String nombre, String domicilio, String ciudad, String cp, String provincia, String pais) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.cp = cp;
        this.provincia = provincia;
        this.pais = pais;
    }
    
    //Getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
}
