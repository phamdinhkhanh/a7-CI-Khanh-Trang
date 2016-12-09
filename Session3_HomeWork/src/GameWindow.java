import Controller.BulletController;
import Controller.KeySetting;
import Controller.PlaneController;
import Model.Model;
import sun.java2d.pipe.BufferedPaints;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static Controller.PlaneController.createPlane;
import static Util.LoadImage.loadImage;
import View.View;


public class GameWindow extends Frame implements Runnable{
    public PlaneController planeController, planeEnemyController;
    public Image background;
    public BufferedImage bufferedImage;
    Vector<BulletController> bulletVector = new Vector<BulletController>();
    Vector<BulletController> bulletEnemyVector = new Vector<BulletController>();
    public int run =0;
    public double run2 =0;


    public GameWindow() {
        setVisible(true);
        setSize(600,800);
        background = loadImage("resources/background.png");
        bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);


        planeEnemyController = createPlane(200,-5,"resources/plane1.png");
        planeController = createPlane(300,700,"resources/plane4.png");
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
            planeController.keySetting(e);

            if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Model bulletModel = new Model(planeController.model.getX()+planeController.model.getWidth()/2-6,planeController.model.getY()-30,30,12);
            View bulletView = new View(loadImage("resources/bullet.png"));
            BulletController bullet = new BulletController(bulletModel, bulletView);
            bulletVector.add(bullet);}


        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });
        repaint();
    }
    public void update(Graphics g) {
        Graphics bufferGraphic = bufferedImage.getGraphics();
        bufferGraphic.drawImage(background, 0,0,600,800,null);
        planeController.draw(bufferGraphic);
        planeEnemyController.draw(bufferGraphic);
        for(BulletController bullet: bulletVector) {
            bullet.draw(bufferGraphic);
        }
        for(BulletController bullet: bulletEnemyVector){
            bullet.draw(bufferGraphic);
        }

        g.drawImage(bufferedImage,0,0,600,800,null);
    }

    public void run(){
        while(true) {
            try{Thread.sleep(17);

                run += 2;
                run2 += 0.5;
                if(run >= 300){
                    planeEnemyController= createPlane(200,0,"resources/plane1.png");
                    run = 0;
                }
                //System.out.println(run);
                if(run2 >= 20) {
                    Model bulletModel = new Model(planeEnemyController.model.getX() + planeEnemyController.model.getWidth() / 2 - 20, planeEnemyController.model.getY() + 60, 40, 40);
                    View bulletView = new View(loadImage("resources/enemy_bullet.png"));
                    BulletController bullet = new BulletController(bulletModel, bulletView);
                    bulletEnemyVector.add(bullet);
                    run2=0;
                }

                for(BulletController bullet: bulletEnemyVector){
                    bullet.model.move(0,+10);
                    System.out.println(bullet.model.getY());
                }

                for(BulletController bullet: bulletVector){
                    bullet.model.move(0,-5);
                }
                planeEnemyController.model.move(0,+7);

                repaint();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
