package Controller;
import Model.Model;
import View.View;

import java.awt.event.KeyEvent;

import static Util.loadImage.loadImage;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class PlaneController extends Controller {
    public static final int SPEED = 5;
    public KeySetting keySetting;

    public PlaneController(Model model, View view) {
        super(model, view);
    }

    public void keyPressed(KeyEvent e) {
        if (keySetting != null) {
            int key = e.getKeyCode();
            if (key == keySetting.getKeyUp()) {
                model.move(0, -SPEED);//hardcode
            } else if (key == keySetting.getKeyDown()) {
                model.move(0, SPEED);
            } else if (key == keySetting.getKeyLeft()) {
                model.move(-SPEED, 0);
            } else if (key == keySetting.getKeyRight()) {
                model.move(SPEED, 0);
            }
        }
    }

    public static PlaneController createPlane(int x, int y){
        PlaneController planeController = new PlaneController(
                new Model(x,y,70,50),
                new View(loadImage("resources/plane3.png"))
        );
        return planeController;
    }
}
