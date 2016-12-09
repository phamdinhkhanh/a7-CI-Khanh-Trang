package Controller;

import Model.Model;
import View.View;

public class BulletController extends Controller{
    public BulletController(Model model,  View view) {
        super(model,view);
    }

    public void run(int dx) {
        this.model.move(0,-7);
    }
}
