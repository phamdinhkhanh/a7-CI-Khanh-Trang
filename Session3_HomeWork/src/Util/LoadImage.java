package Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by laptopTCC on 12/9/2016.
 */
public class LoadImage {
    public static Image loadImage(String url) {
        try {
            Image image = ImageIO.read (new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
