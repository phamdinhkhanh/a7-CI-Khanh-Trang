package Model;

/**
 * Created by laptopTCC on 12/9/2016.
 */
public class Model {
    public int x;
    public int y;
    public int height;
    public int width;

    public Model(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
}
