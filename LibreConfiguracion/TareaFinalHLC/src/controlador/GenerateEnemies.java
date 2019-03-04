/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import modelo.Enemy;
import modelo.Sleep;
import vista.CanvasGame;

/**
 *
 * @author Sergio Moreno Antequera
 */
public class GenerateEnemies extends Thread {
    
    CanvasGame cv;
    public ArrayList<Enemy> enemies;
    int id;
    
    public GenerateEnemies(CanvasGame cv) {
        this.cv = cv;
        enemies = new ArrayList<Enemy>();
        id = 0;
    }

    @Override
    public void run() {
        super.run();
        while (id < 10) {
            Enemy enemy = new Enemy(id++);
            MoveEnemy moveHim = new MoveEnemy(enemy, cv);
            moveHim.start();

            enemies.add(enemy);
            Sleep.sleep(1800);
        }
    }
}
