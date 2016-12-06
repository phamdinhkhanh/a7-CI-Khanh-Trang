package Controllers;

import Models.PlaneModel;
import Views.KeySetting;
import Views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class PlaneController {
    public PlaneModel planeModel;
    public PlaneView planeView;
    public KeySetting keySetting;
    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.planeModel = planeModel;
        this.planeView = planeView;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(keySetting != null) {
            if (key == keySetting.keyUp) {
            planeModel.move(0,-7);
            }
            else if (key == keySetting.keyDown) {
                planeModel.move(0,+7);
            }
            else if (key == keySetting.keyRight) {
                planeModel.move(+7,0);
            }
            else if (key == keySetting.keyLeft) {
                planeModel.move(-7,0);
            }
        }
    }
    public void draw(Graphics g)
    {
        planeView.draw(g,planeModel);
    }
}
