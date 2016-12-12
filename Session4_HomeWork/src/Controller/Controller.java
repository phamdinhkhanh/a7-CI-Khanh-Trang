package Controller;

import Model.Model;
import View.View;

import java.awt.*;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class Controller {
    public Model model;
    public View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void draw(Graphics g) {
        view.draw(g,model);
    }

    public void run(){
        model.move(0,5);
    }

    public void run1(){
        model.move(-5,5);
    }
}
