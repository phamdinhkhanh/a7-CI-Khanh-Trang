/**
 * Created by laptopTCC on 11/30/2016.
 */
public class Program {
    public static void main(String[] args)
    {
        System.out.println("Hello world");
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }

}
