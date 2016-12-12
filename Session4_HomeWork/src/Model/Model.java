package Model;

/**
 * Created by laptopTCC on 12/11/2016.
 */
public class Model {
    public int x;
    public int y;
    public int WIDTH;
    public int HEIGHT;

    public Model(int x, int y, int WIDTH, int HEIGHT) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
}
