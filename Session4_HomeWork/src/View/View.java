package View;

import java.awt.*;
import Model.Model;
/**
 * Created by laptopTCC on 12/11/2016.
 */
public class View {
    public Image image;

    public View(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, Model model){
       g.drawImage(image,model.x,model.y,model.WIDTH, model.HEIGHT,null);
   }
}
