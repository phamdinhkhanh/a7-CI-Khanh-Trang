package Controllers;


import Controllers.managers.Body;
import Controllers.managers.BodyManager;
import Models.Model;
import Views.View;


import java.awt.*;
import java.util.Vector;

import static Utils.Utils.loadImage;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class EnemyBulletController extends Controllers implements Body{
    public static final int WIDTH =30;
    public static final int HEIGHT =30;


    public EnemyBulletController(Model model,View view) {
        super(model,view);
        BodyManager.instance.register(this);
    }

    public void run(){
            this.model.move(0,7);
    }


    public static EnemyBulletController createBullet(int x, int y){
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new Model(x,y,EnemyBulletController.WIDTH,EnemyBulletController.HEIGHT,15,15,15),
                new View(loadImage("resources/enemy_bullet.png"))
        );
        return  enemyBulletController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof  PlaneController) {
        System.out.println("EB:");
            this.model.isAlive();
        }
    }
}
