package Views;

import java.awt.*;
import Models.Model;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class View {
    public Image image;

    public View(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, Model model){
        g.drawImage(image,model.getX(),model.getY(),model.getWidth(),model.getHeight(),null);
    }
}
