 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author windiurno
 */
public class Sonidos {
    
    public static final AudioClip SOUNDPELOTA = Applet.newAudioClip(Sonidos.class.getResource("src/source/ball.wav"));
    public static final AudioClip SOUNDGAMEOVER = Applet.newAudioClip(Sonidos.class.getResource("src/source/gameover.wav"));
    
}
