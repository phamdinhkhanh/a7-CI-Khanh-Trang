package Controllers;


import Controllers.managers.Body;
import Controllers.managers.BodyManager;
import Models.Model;
import Views.View;
import static Utils.Utils.loadImage;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class BulletController extends Controllers implements Body {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 30;

    public BulletController(Model model,View view) {
        super(model,view);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0,-5);
    }

    public static BulletController createBullet(int x,int y){
        BulletController bulletController = new BulletController(
                new Model(x,y,WIDTH,HEIGHT,10,10,10),
                new View(loadImage("resources/bullet.png"))
        );
        return bulletController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController) {
            System.out.println("Oh yeah");
            this.model.isAlive();
            this.model.atk(other.getModel());
        }
    }
}
