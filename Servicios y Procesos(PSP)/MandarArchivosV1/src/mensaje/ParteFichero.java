/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaje;

/**
 *
 * @author windiurno
 */
public class ParteFichero {
    
    private String nombreFichero;
    private boolean ultimaParte;
    private int bytesValidos;
    private byte [] parte = new byte[1024]; //Vamos mandando el paquete en 1024 bytes
    
    //--------------------------------------------------------------------------
    
    public ParteFichero(){}
    
    //--------------------------------------------------------------------------

    //getters y Setters
    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public boolean isUltimaParte() {
        return ultimaParte;
    }

    public void setUltimaParte(boolean ultimaParte) {
        this.ultimaParte = ultimaParte;
    }

    public int getBytesValidos() {
        return bytesValidos;
    }

    public void setBytesValidos(int bytesValidos) {
        this.bytesValidos = bytesValidos;
    }

    public byte[] getParte() {
        return parte;
    }

    public void setParte(byte[] parte) {
        this.parte = parte;
    }
}
