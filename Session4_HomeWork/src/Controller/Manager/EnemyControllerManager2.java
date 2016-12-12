package Controller.Manager;

import Controller.EnemyController;
import java.util.Vector;

import static Controller.EnemyController.createEnemy;

/**
 * Created by laptopTCC on 12/12/2016.
 */
public class EnemyControllerManager2 extends ControllerManager {
    public Vector<EnemyController> enemyController2s;
    public int timeCounter = 0;
    public EnemyControllerManager2() {
        this.enemyController2s = new Vector<>();
    }
    public void run(){
        super.run1();
        spawn();
    }
    public void spawn(){
        timeCounter++;
        if(timeCounter > 20){
            EnemyController enemyController = createEnemy(600,0);
            enemyController2s.add(enemyController);
        }
    }
}
