package Controllers;

import Controllers.managers.Body;
import Controllers.managers.BodyManager;
import Models.Model;
import Views.View;

import java.awt.*;
import java.util.Vector;
import static Controllers.EnemyBulletController.createBullet;
import static Utils.Utils.loadImage;

public class EnemyController extends Controllers implements Body {

    private final int SPEED = 5;
    private int hp;
    private static final int atk = 15;
    private static final int def = 5;
    public static final int WIDTH =50;
    public static final int HEIGHT =70;
    public int timeCounter = 0;
    public Vector<EnemyBulletController> enemyBulletControllers= new Vector<>();

    public EnemyController(Model model,View view) {
        super(model, view);
        timeCounter = 0;
        BodyManager.instance.register(this);
    }


    public void run(){
        timeCounter ++;
        this.model.move(SPEED,0);
        if(timeCounter>20){
            shoot();
            timeCounter = 0;
            //System.out.println("So vien dan ban ra: "+enemyBulletControllers.size());
        }
        for(EnemyBulletController enemyBulletController: enemyBulletControllers){
            enemyBulletController.run();
        }
    }

    public void draw(Graphics g) {
        super.draw(g);
        for(EnemyBulletController enemyBulletController: this.enemyBulletControllers){
            enemyBulletController.draw(g);
        }
    }



    public void shoot(){
        int x = this.getModel().getMidX() - EnemyBulletController.WIDTH / 2;
        int y = this.getModel().getButtom();
        EnemyBulletController enemyBulletController = createBullet(x,y);
        enemyBulletControllers.add(enemyBulletController);
    }

    public static EnemyController createEnemy(int x, int y){
        EnemyController enemyController = new EnemyController(
                new Model(x,y,WIDTH,HEIGHT,100,atk,def),
                new View(loadImage("resources/plane1.png"))
        );
        return enemyController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletController) {
            //System.out.println("Hu hu");
            this.model.isAlive();
            this.model.atk(other.getModel());
            System.out.println("Mau may bay dich: "+this.model.getHp());
        }
    }
}
