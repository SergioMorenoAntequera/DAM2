package app;

import controlador.CtrlInformes;
import vista.DialogoInformes;

/**
 * @author Angel Salas Calvo
 */
public class Main {
    public static void main(String[] args) {
        DialogoInformes vis = new DialogoInformes(null, true);
        CtrlInformes ctrlInfo = new CtrlInformes(vis);

        ctrlInfo.iniciar();
        vis.setVisible(true);
    }
}
