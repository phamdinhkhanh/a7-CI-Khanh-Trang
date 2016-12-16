package Controllers;

import Models.Model;
import Views.View;

import java.awt.*;
import java.util.Vector;


/**
 * Created by laptopTCC on 12/7/2016.
 */
public class Controllers {
    public Model model;
    public View view;
    private final int SPEED = 7;

    public void run(){
        model.move(+SPEED,+SPEED);
    }

    public void draw(Graphics g) {
        view.draw(g,model);
    }

    public Controllers(Model model,View view) {
        this.view = view;
        this.model = model;
    }



    public Model getModel() {
        return model;
    }
}

