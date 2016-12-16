package Controllers.managers;
import Controllers.EnemyController;
import static Controllers.EnemyController.createEnemy;


/**
 * Created by laptopTCC on 12/10/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    int time = 0;

    @Override
    public void run() {
        time++;
        super.run();
        if(time > 20){
            time = 0;
            spawn();
        }
    }

    public void spawn(){
        // 1: create enemy
        EnemyController enemyController = createEnemy(300,0);
        // 2: add enemy to vector
        this.controllers.add(enemyController);
    }
}
