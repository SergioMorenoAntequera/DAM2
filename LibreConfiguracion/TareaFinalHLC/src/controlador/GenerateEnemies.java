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
import vista.Frame;

/**
 *
 * @author Sergio Moreno Antequera
 */
public class GenerateEnemies extends Thread{
    
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
        while (true) {
            if (id < 10) {
                
                //Sleep.sleep(1);
                Enemy enemy = new Enemy(id++);
                enemies.add(enemy);
            }
            
            Sleep.sleep(100);
            moveEnemies();  
        }
    }

    private void moveEnemies(){
        
        for(Enemy en : enemies){
            
            if(en.getxPosition() > 332){
                en.setxPosition(en.getxPosition()-1);
            } else {
                en.setxPosition(en.getxPosition()+1);
            }
            if(en.getyPosition() > 185){
                en.setyPosition(en.getyPosition()-1);
            } else {
                en.setyPosition(en.getyPosition()+1);
            }
            
        }
    }
    
}
