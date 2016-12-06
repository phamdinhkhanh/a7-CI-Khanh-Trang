package Views;

import Models.BulletModel;

import java.awt.*;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class BulletView {
    public BulletModel bulletModel;
    public Image image;

    public BulletView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, BulletModel bulletModel){
        g.drawImage(image,bulletModel.x,bulletModel.y,15,30,null);
    }
}
