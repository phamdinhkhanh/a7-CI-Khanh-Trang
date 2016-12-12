package Controller.Manager;

import Controller.Controller;

import java.util.Vector;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class ControllerManager {
    protected Vector<Controller> Controllers;
    public ControllerManager() {
        Controllers = new Vector<>();
    }
    public void run(){
        for(Controller controller: Controllers){
            controller.run();
        }
    }
    public void run1(){
        for(Controller controller: Controllers){
            controller.run1();
        }
    }

    public void add(Controller controller){
        Controllers.add(controller);
    }

    public void remove(Controller controller) {
        Controllers.remove(controller);
    }
}

