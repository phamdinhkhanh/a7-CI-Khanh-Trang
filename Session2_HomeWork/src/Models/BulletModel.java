package Models;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class BulletModel {
    public int x;
    public int y;
    public int move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        return x;
    }
    public BulletModel(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
