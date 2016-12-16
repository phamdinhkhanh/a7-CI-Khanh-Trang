package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by laptopTCC on 12/7/2016.
 */
public class Utils {
    public static Image loadImage(String url)
    {
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
