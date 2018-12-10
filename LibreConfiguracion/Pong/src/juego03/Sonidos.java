 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego03;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author windiurno
 */
public class Sonidos {
    
    public static final AudioClip SOUNDPELOTA = Applet.newAudioClip(Sonidos.class.getResource("src/sonidos/ball.wav"));
    public static final AudioClip SOUNDGAMEOVER = Applet.newAudioClip(Sonidos.class.getResource("src/sonidos/gameover.wav"));
    
}
