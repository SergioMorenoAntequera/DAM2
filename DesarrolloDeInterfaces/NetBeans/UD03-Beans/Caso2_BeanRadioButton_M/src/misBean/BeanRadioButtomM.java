/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misBean;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JRadioButton;

/**
 *
 * @author windiurno
 */
public class BeanRadioButtomM extends JRadioButton implements Serializable {
    //Hemos borrado todo el codigo generado menos el constructor 
    //que lo hemos vaciado
    
    //Poniendo los getters y los setters de los atributos se convierten en
    //propiedades para poder modificarlos cuando los usemos como bean.
    private String texto;
    private Color colorTexto;
    private boolean habilitado;
    private boolean invisible;
    private boolean seleccionado;
    
    //--------------------------------------------------------------------------
    
    public BeanRadioButtomM() {
        this.texto = "Item1";
        this.colorTexto = Color.BLUE;
        this.habilitado = true;
        this.invisible = false;
        this.seleccionado = false;        
        
        //Esto es necesario porque estos metodos están modificados
        this.setTexto(texto);
        this.setColorTexto(colorTexto);
        this.setHabilitado(habilitado);
        this.setInvisible(invisible);
        this.setSeleccionado(seleccionado);
    }
    
    //--------------------------------------------------------------------------
    
    //Getters y setter con algunas modificaciones
    public String getTexto() {
        return "El texto de la etiqueta es: " + texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        this.setText(this.texto);
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
        this.setForeground(colorTexto);
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
        this.setEnabled(this.habilitado);
        if (this.habilitado) {
            System.out.println("Componente activado");
        }
        if (!this.habilitado) {
            System.out.println("Componente deactivado");
        }
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
        this.setVisible(!this.invisible);
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        this.setSelected(this.seleccionado);
    }

}
