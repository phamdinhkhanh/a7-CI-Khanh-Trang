package Controller;

import Model.Model;
import Util.LoadImage;
import View.View;
import static Util.LoadImage.loadImage;

public class PlaneController extends Controller {
    //public Model model;
    public PlaneController(Model model, View view) {
        super(model,view);
    }

    public static PlaneController createPlane(int x, int y, String url){
        PlaneController planeController = new PlaneController(
                new Model(x,y,90,60),
                new View(loadImage(url))
        );
        return planeController;
    }
}
