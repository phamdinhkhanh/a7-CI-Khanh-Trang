package Controller;

import Model.Model;
import View.View;

import static Util.loadImage.loadImage;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class BulletEnemyController extends Controller {
    public BulletEnemyController(Model model, View view){
        super(model, view);
    }
    public void run(){
        model.move(0,7);
    }
    public static BulletEnemyController createBulletEnemyController(EnemyController enemyController){
        int x = enemyController.getModel().getX() + enemyController.getModel().getWIDTH() / 2 - 16;
        int y = enemyController.getModel().getY() + 32;
        BulletEnemyController bulletEnemyController = new BulletEnemyController(
                new Model(x, y, 32, 32),
                new View(loadImage("resources/enemy_bullet.png")));
        return bulletEnemyController;
    }
}
