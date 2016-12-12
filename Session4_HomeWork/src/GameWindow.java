
import Controller.*;
import Model.Model;
import View.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static Controller.EnemyController.createEnemy;
import static Util.loadImage.loadImage;
import static Controller.BulletEnemyController.createBulletEnemyController;
/**
 * Created by laptopTCC on 12/11/2016.
 */
public class GameWindow extends Frame implements Runnable {

    public Image background;
    public PlaneController planeController;
    Vector<BulletController> bulletControllers;
    EnemyController enemyController;
    Vector<BulletEnemyController> bulletEnemyControllers, bulletEnemyController2s;
    Vector<EnemyController> enemyControllers, enemyController2s;
    BufferedImage bufferedImage;
    int timecount1 = 0;
    int timecount2 = 0;
    //public View loadImage;
    public GameWindow() {
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        background = loadImage("resources/background.png");
        bulletControllers = new Vector<>();
        bulletEnemyControllers = new Vector<>();
        bulletEnemyController2s = new Vector<>();
        enemyControllers = new Vector<>();
        enemyController2s = new Vector<>();

        Model model = new Model(300,750,50,80);
        View view = new View(loadImage("resources/plane3.png"));
        planeController = new PlaneController(model, view);
        planeController.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_LEFT
        );
        setSize(600,800);
        setVisible(true);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Close Window");
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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    int x = planeController.getModel().getX() + planeController.getModel().getWIDTH() / 2 - 12 / 2;
                    int y = planeController.getModel().getY() - 32;
                    Model bulletModel = new Model(x, y, 12, 32);
                    View bulletView = new View(loadImage("resources/bullet.png"));
                    BulletController bulletController = new BulletController(bulletModel, bulletView);
                    bulletControllers.add(bulletController);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        repaint();
    }
    public void update(Graphics g) {
        Graphics bufferedGraphic = bufferedImage.getGraphics();
        bufferedGraphic.drawImage(background,0,0,600,800,null);
        for(BulletController bullet:  bulletControllers){
            bullet.draw(bufferedGraphic);
        }
        for(EnemyController enemyController: enemyControllers){
            enemyController.draw(bufferedGraphic);
        }

        for(EnemyController enemyController: enemyController2s){
            enemyController.draw(bufferedGraphic);
        }
        for(BulletEnemyController bulletEnemyController: bulletEnemyControllers){
            bulletEnemyController.draw(bufferedGraphic);
        }
        for(BulletEnemyController bulletEnemyController: bulletEnemyController2s){
            bulletEnemyController.draw(bufferedGraphic);
        }
        planeController.draw(bufferedGraphic);
        g.drawImage(bufferedImage,0,0,600,800,null);

    }
    public void run(){
        while(true) {
            timecount1 += 17;
            timecount2 += 10;
            if(timecount1 > 1000){
                EnemyController enemyController = createEnemy(300,0);
                enemyControllers.add(enemyController);
                timecount1 = 0;
            }

            if(timecount2 > 300){
                EnemyController enemyController2 = createEnemy(600,0);
                enemyController2s.add(enemyController2);
                timecount2 = 0;
            }


            for(EnemyController enemyController: enemyControllers) {
                if (timecount1 == 0) {
                    BulletEnemyController bulletEnemyController = createBulletEnemyController(enemyController);
                    bulletEnemyControllers.add(bulletEnemyController);
                }
            }

            for(EnemyController enemyController: enemyController2s) {
                if (timecount2 == 0) {
                    BulletEnemyController bulletEnemyController2 = createBulletEnemyController(enemyController);
                    bulletEnemyController2s.add(bulletEnemyController2);
                }
            }

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(BulletController bullet: bulletControllers) {
                bullet.model.move(0,-7);
            }

            for(BulletEnemyController bulletEnemyController: bulletEnemyControllers){
                bulletEnemyController.run();
            }
            for(BulletEnemyController bulletEnemyController: bulletEnemyController2s){
                bulletEnemyController.run();
            }

            for(EnemyController enemyController: enemyControllers){
                enemyController.run();
            }
            for(EnemyController enemyController: enemyController2s){
                enemyController.run1();
            }
            System.out.println("Size "+enemyController2s.size());
            this.repaint();
        }
    }
}
