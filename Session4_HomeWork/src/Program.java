/**
 * Created by laptopTCC on 12/11/2016.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gm = new GameWindow();
        Thread thread = new Thread(gm);
        thread.start();
    }
}
