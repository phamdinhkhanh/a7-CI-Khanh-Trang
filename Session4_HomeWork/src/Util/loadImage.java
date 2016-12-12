package Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class loadImage {
    public static Image loadImage(String url) {
        Image image = null;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
