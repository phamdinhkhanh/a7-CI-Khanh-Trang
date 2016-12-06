import Controllers.BulletController;
import Controllers.PlaneController;
import Models.BulletModel;
import Models.PlaneModel;
import Views.BulletView;
import Views.KeySetting;
import Views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class GameWindow extends Frame implements Runnable{
    public PlaneController planeController;
    public BulletController bullet;
    public Image backGround = loadImage("resources/background.png");
    public BufferedImage bufferedImage;
    public Image loadImage(String url)
    {
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    Vector<BulletController> bulletVector =new <BulletController>();

    public GameWindow(){
        setVisible(true);
        setSize(600,800);
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        PlaneModel planeModel = new PlaneModel(200,300);
        PlaneView planeView = new PlaneView(loadImage("resources/plane4.png"));
        KeySetting keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_LEFT
        );
        planeController = new PlaneController(planeModel, planeView);
        planeController.keySetting = keySetting;
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Close");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            planeController.keyPressed(e);
            repaint();
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                int x = planeModel.getX();
                int y = planeModel.getY();
                BulletModel bulletModel = new BulletModel(x, y);
                BulletView bulletView = new BulletView(loadImage("resources/bullet.png"));
                bullet = new BulletController(bulletModel, bulletView);
                bulletVector.add(bullet);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.repaint();
    }
    public void update(Graphics g) {
        Graphics bufferedGraphic = bufferedImage.getGraphics();
        bufferedGraphic.drawImage(backGround,0,0,600,800,null);
        planeController.draw(bufferedGraphic);
        if(bullet != null) {
            for (BulletController bullet : bulletVector) {
                bullet.draw(bufferedGraphic);
            }
        }
        g.drawImage(bufferedImage,0,0,600,800,null);
    }

    public void run(){
        why(true) {
        try {
            Thread.sleep(17);
            for (BulletController bullet : bulletVector) {
                bullet.bulletModel.y -= 7;
                this.repaint();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        }
    }
}
