package Controller;

import Model.Model;
import View.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/9/2016.
 */
public class Controller {
    public Model model;
    public View view;
    public KeySetting keySetting;
    public final int SPEED = 7;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void keySetting(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == keySetting.keyUp){
            model.move(0,-SPEED);
            System.out.println(model.getX()+" "+model.getY());
        }
        else if (key == keySetting.keyDown){
            model.move(0,SPEED);
        }
        else if (key == keySetting.keyRight){
            model.move(SPEED,0);
        }
        else if (key == keySetting.keyLeft){
            model.move(-SPEED,0);
        }
    }

    public void draw(Graphics g) {
        view.draw(g,model);
    }
}
