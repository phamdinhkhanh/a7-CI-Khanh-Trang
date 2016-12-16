package Controllers;

import Controllers.managers.Body;
import Controllers.managers.BodyManager;
import Models.Model;
import Views.KeySetting;
import Views.View;
import java.awt.event.KeyEvent;

import static Utils.Utils.loadImage;


public class PlaneController extends Controllers implements Body{
    private static final int SPEED = 5;
    private int hp;
    private static final int def = 10;
    private static final int atk = 10;
    public KeySetting keySetting;

    public PlaneController(Model model,View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(keySetting != null) {
            if (key == keySetting.keyUp) {
                model.move(0,-SPEED);
                System.out.println("Keyup");
                System.out.println(model.getX()+" "+model.getY());
            }
            else if (key == keySetting.keyDown) {
                model.move(0,SPEED);
            }
            else if (key == keySetting.keyRight) {
                model.move(+SPEED,0);
            }
            else if (key == keySetting.keyLeft) {
                model.move(-SPEED,0);
            }
        }
    }
    public static PlaneController createPlane(int x, int y){
        PlaneController planeController = new PlaneController(
                new Model(x,y,50,70,500,atk,def),
                new View(loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        //this.model.atk(other);
        if(other instanceof EnemyBulletController) {
            //System.out.println("EB: ");
            this.model.atk(other.getModel());
            this.model.isAlive();
        }
        System.out.println("Mau cua may bay ta" + this.model.getHp());
    }
}
