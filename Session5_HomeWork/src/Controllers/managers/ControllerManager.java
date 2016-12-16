package Controllers.managers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;
import Controllers.Controllers;

/**
 * Created by laptopTCC on 12/10/2016.
 */
public class ControllerManager {
    protected Vector<Controllers> controllers;

    public ControllerManager() {
        controllers = new Vector<>();
    }

    public void draw(Graphics g) {
        for(Controllers controller: this.controllers){
            controller.draw(g);
        }
        Iterator<Controllers> iterator = this.controllers.iterator();
        while(iterator.hasNext()) {
            Controllers controllers = iterator.next();
            if(!controllers.getModel().isAlive()){
                iterator.remove();
            }
        }
    }
    public void run(){
        for(Controllers controller: this.controllers){
            controller.run();
        }
    }

    public void add(Controllers controller) {
        controllers.add(controller);
    }

    public void remove(Controllers controller) {
        controllers.remove(controller);
    }
}
