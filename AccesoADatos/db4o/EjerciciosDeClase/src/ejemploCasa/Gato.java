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
public class Gato {
    
    String colorPelo;
    String comida;
    Humano humano;
    
    //-------------------------------------------------
    
    public Gato(String colorPelo, String comida, Humano humano) {
        this.colorPelo = colorPelo;
        this.comida = comida;
        this.humano = humano;
    }

    //--------------------------------------------------
    
    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public Humano getHumano() {
        return humano;
    }

    public void setHumano(Humano humano) {
        this.humano = humano;
    }

    @Override
    public String toString() {
        return "Gato{" + "colorPelo=" + colorPelo + ", comida=" + comida + ", humano=" + humano + '}';
    }
    
    
}
