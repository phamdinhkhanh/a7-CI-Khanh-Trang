import Controllers.BulletController;
import Controllers.EnemyController;
import Controllers.PlaneController;
import Controllers.managers.BodyManager;
import Controllers.managers.EnemyControllerManager;
import Models.Model;
import Views.KeySetting;
import Views.View;
import com.intellij.openapi.vfs.encoding.PlatformFileEncodingConfigurable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static Controllers.EnemyController.createEnemy;
import static Controllers.PlaneController.createPlane;
import static Utils.Utils.loadImage;
import static Controllers.BulletController.createBullet;
import static java.awt.SystemColor.window;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class GameWindow extends Frame implements Runnable{
    public PlaneController planeController;
    public EnemyControllerManager enemyControllerManager;
    public EnemyController enemyController;
    public Image backGround = loadImage("resources/background.png");
    public Image gameOver = loadImage("resources/gameover.png");
    public BufferedImage bufferedImage;
    public int timeCounter2 = 0;
    public int timeCounter1 = 0;
    public Vector<PlaneController> planeControllers = new Vector<>();
    // Design pattern:
    // Factory
    Vector<BulletController> bulletVector = new Vector<BulletController>();

    public GameWindow(){
        setVisible(true);
        setSize(1600,1000);

        enemyControllerManager = new EnemyControllerManager();
        enemyController = createEnemy(300,0);
        enemyControllerManager.add(enemyController);
        bufferedImage = new BufferedImage(1600,1000,BufferedImage.TYPE_INT_ARGB);
        planeController = createPlane(800,900);
        planeController.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_LEFT
        );
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
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {   int x = planeController.model.getX()+planeController.model.getWidth()/2-BulletController.WIDTH/2;
                    int y = planeController.model.getY()-30;
                    BulletController bullet = createBullet(x,y);
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
        if(!planeController.getModel().isAlive()){
            bufferedGraphic.drawImage(backGround,0,0,1600,1000,null);
            bufferedGraphic.drawImage(gameOver,400,250,800,500, null);
        } else {
            bufferedGraphic.drawImage(backGround,0,0,1600,1000,null);
            enemyControllerManager.draw(bufferedGraphic);
            planeController.draw(bufferedGraphic);

            for (BulletController bullet : bulletVector) {
                bullet.draw(bufferedGraphic);
            }
        }
        g.drawImage(bufferedImage,0,0,1600,1000,null);

        //System.out.println("Ban con song hay khong "+planeController.getModel().isAlive());
    }

    public void run(){
        while(true) {
            timeCounter2 += 1;
            timeCounter1 += 1;
            //System.out.println(timeCounter);
            try {
                Thread.sleep(17);
                for (BulletController bullet : bulletVector) {
                    bullet.run();
                }
               /* enemyController.run();
                System.out.println(enemyController.model.getY());
                enemyController.shoot();*/

                BodyManager.instance.checkContact();

                if(timeCounter1 > 2){
                    enemyControllerManager.run();
                    timeCounter1 = 0;
                }

                this.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
