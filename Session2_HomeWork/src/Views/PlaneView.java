package Views;

import Models.PlaneModel;

import java.awt.*;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class PlaneView {
    public PlaneModel planeModel;
    public Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, PlaneModel planeModel) {
        g.drawImage(image,planeModel.x,planeModel.y,40,70,null);
    }
}
