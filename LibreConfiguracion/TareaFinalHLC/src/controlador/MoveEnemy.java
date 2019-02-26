/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Enemy;
import modelo.Sleep;

/**
 *
 * @author Sergio Moreno Antequera
 */
public class MoveEnemy extends Thread {

    //Este hilo se lanza cada vez que se genera un enemigo en GenerateEnemies
    public Enemy enemy;
    //Cuanto menor sea la "speed" menos tarda
    int speed;
    
    //--------------------------------------------------------------------------
    
    public MoveEnemy(Enemy e){
        this.enemy = e;
        this.speed = 10;
    }

    //--------------------------------------------------------------------------
    
    @Override
    public void run() {
        while (enemy.getyPosition() < 550) {
            enemy.setyPosition(enemy.getyPosition() + 1);
            Sleep.sleep(speed);
        }
    }
}
