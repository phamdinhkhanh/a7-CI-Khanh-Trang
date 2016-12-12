package Controller.Manager;

import Controller.EnemyController;

import java.util.Vector;

import static Controller.EnemyController.createEnemy;
/**
 * Created by laptopTCC on 12/11/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    public Vector<EnemyController> enemyControllers;
    public EnemyControllerManager(){
        this.enemyControllers = new Vector<>();
    }

    public int timeCounter = 0;

    public void run(){
        super.run();
        spawn();
    }
    public void spawn(){
        timeCounter++;
        if(timeCounter > 20){
            EnemyController enemyController = createEnemy(300,0);
            enemyControllers.add(enemyController);
        }
    }
}
