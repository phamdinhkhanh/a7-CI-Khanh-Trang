package Models;

import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class PlaneModel {
    public int x;
    public int y;
    public int move(int dx, int dy){
        this.x += dx;
        this.y += dy;
        return x;
    }

    public PlaneModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
