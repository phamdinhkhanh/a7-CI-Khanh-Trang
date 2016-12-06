package Controllers;

import Models.BulletModel;
import Views.BulletView;
import Views.PlaneView;


import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class BulletController {
    public BulletModel bulletModel;
    public BulletView bulletView;
    public BulletController(BulletModel bulletModel,BulletView bulletView)
    {
        this.bulletModel = bulletModel;
        this.bulletView = bulletView;
    }
    public void draw(Graphics g)
    {
        bulletView.draw(g,bulletModel);
    }
}
