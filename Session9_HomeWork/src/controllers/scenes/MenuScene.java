package controllers.scenes;

import controllers.GameSetting;
import controllers.PlaneController;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by laptopTCC on 12/30/2016.
 */
public class MenuScene extends GameScene {
    Image background;
    public MenuScene(){
        background = loadImage("resources/1945-logo.png");
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0,0,GameSetting.instance.getWidth(),GameSetting.instance.getHeight(),null);
        System.out.println("Update logo");
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new PlayGameScene(),true);
    }

    public void destroy(){

    }
}
