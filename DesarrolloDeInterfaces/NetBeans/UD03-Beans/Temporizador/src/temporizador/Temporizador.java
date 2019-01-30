/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//1ºCreación del componente. Creación del proyecto y tipo componente JavaBeans.
package temporizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.*;

/**
 *
 * @author windiurno
 */
public class Temporizador extends JLabel implements ActionListener,Serializable {
    //4ºGestión de eventos del componente
    //4º1-clase que implement los eventos
    public class FinCuentaAtrasEvent extends java.util.EventObject{
        // constructor
        public FinCuentaAtrasEvent(Object source){
            super(source);
        }
    }

//4º2-Define la interfaz para el nuevo tipo de evento con los métodos a usar cuando se genere el evento.
    public interface FinCuentaAtrasListener extends EventListener{
        void capturarFinCuentaAtras(FinCuentaAtrasEvent ev);
    }
    //4º3-Oyente
    private FinCuentaAtrasListener receptor;
    
   //2ºAdicción de las propiedades.
    //En una clase Java se realiza simplemente escribiendo el código de declaración
    //del atributo privado (o protegido) y los métodos getter y setter que son 
    //la base de instrosprección.
    protected int tiempo;
    
    //propiedad compartida o ligada, notifica a otros objetos oyentes interesados, 
    //cuando el valor de dicha propiedad cambia, permitiendo a estos objetos 
    //realizar alguna acción. Cuando la propiedad cambia , se crea un objeto 
    //(de una clase que hereda de ObjetEvent) que contiene información acerca
    //de la propiedad (su nombre, el valor previo y el nuevo valor), y lo pasa 
    //a los otros oyentes interesados en el cambio.
    public static final String PROP_TIEMPO = "tiempo";
    

    /**
     * Get the value of tiempo
     *
     * @return the value of tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Set the value of tiempo
     *
     * @param tiempo new value of tiempo
     */
    public void setTiempo(int tiempo) {
        int oldTiempo = this.tiempo;
        this.tiempo = tiempo;
        //reflejar el cambio del tiempo en la etiqueta y repintarla
        setText(Integer.toString(tiempo));
        repaint();
        propertyChangeSupport.firePropertyChange(PROP_TIEMPO, oldTiempo, tiempo);
    }
    //3ºImplementar el Comportamiento.
    //Parte de un valor inicial que irá disminuyento cada segundo hasta llegar a cero,
    //para implementar esto utilizaremos un Timer, que añadimos como un atributo
    //privado de la clase.Ejecutara el método actionPerformed cada segundo.Tambíen
    //hay que pasarle el objeto actionPerformed con el método a ejecutar, en nuestro
    //caso, como necesitamos acceder a atributos de la etiqueta y a la propiedad tiempo, 
    //usaremos el de la propia clase. Para que la clase pueda tener el método
    //actionPerformed tendrá que implementar la interfaz ActionListener.
    private Timer t;

    //Activo es en si mismo una propiedad (sin atributo subyacente)
    //Gestiona si el temporizador está funcionado o no.
    public final void setActivo(boolean valor) {
        if (valor == true)
            t.start();
        else
            t.stop();
    }
    //devuelve si esta activo
    public boolean getActivo() {
        return t.isRunning();
    }

    //Constructor sin argumentos. Se establece como tiempo por defecto 5 segundos.
    public Temporizador() {
        
        tiempo = 5;
        /*Los temporizadores se construyen especificando un parámetro de retardo 
        y un ActionListener. El parámetro de retardo se usa para establecer el 
        retardo inicial y el retardo entre el disparo del evento, en milisegundos. 
        Una vez que se ha iniciado el temporizador, espera la demora inicial antes 
        de disparar su primer evento de acción a los oyentes registrados. Después 
        de este primer evento, continúa disparando eventos cada vez que ha transcurrido 
        el retraso entre eventos, hasta que se detiene.*/
        t = new Timer (1000, this);
        setText(Integer.toString(tiempo));
        setActivo(true);
    }

    //Accion que se realiza cada vez que se cumplen los 1000 milisegudos establecidos
    //para t. se modifica el valor del texto de la etiqueta, se repinta y se disminuye
    //en un segundo el tiempo restante.
    //Cuando el tiempo llega a cero se para el Timer
        @Override
    public void actionPerformed(ActionEvent e)
    {
        // Aquí el código que queramos ejecutar.
        setText(Integer.toString(tiempo));
        repaint();
        tiempo--;
        if(tiempo == 0){
            setActivo(false);
            receptor.capturarFinCuentaAtras( new FinCuentaAtrasEvent(this));
        }
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    //4º3-dos métodos que permiten al componenete ayadir oyentes y eliminarlos.
    public void addFinCuentaAtrasListener(FinCuentaAtrasListener receptor)
    {
        this.receptor = receptor;
    }

    public void removeFinCuentaAtrasListener(FinCuentaAtrasListener receptor)
    {
        this.receptor=null;
    }
}