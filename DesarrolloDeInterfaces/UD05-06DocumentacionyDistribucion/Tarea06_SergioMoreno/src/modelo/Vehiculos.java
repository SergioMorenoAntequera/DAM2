/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author seran
 */
public class Vehiculos {
    
    private String matricula;
    private String marca;
    private String modelo;
    private int nKilometros;
    private String fRevision;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getnKilometros() {
        return nKilometros;
    }

    public void setnKilometros(int nKilometros) {
        this.nKilometros = nKilometros;
    }

    public String getfRevision() {
        return fRevision;
    }

    public void setfRevision(String fRevision) {
        this.fRevision = fRevision;
    }
    
    
    
}
