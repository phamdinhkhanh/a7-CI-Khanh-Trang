import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import static java.lang.System.in;

/**
 * Created by laptopTCC on 12/1/2016.
 */
public class GameWindow3 extends Frame{
    Image background, plane, planeE1,planeE2, planeE3,planeE4,bullet, bulletE1, bulletE2, bulletE3, bulletE4;
    int planeX = 700,planeY = 550,planeE1X = 300, planeE1Y = 10,planeE2X = 500, planeE2Y = -100;
    int planeE3X = 700, planeE3Y = -400,planeE4X = 600, planeE4Y = 10;
    int bulletX = 755, bulletY = 520, bulletE1X = planeE1X+55, bulletE1Y = planeE1Y+140;
    int bulletE2X = planeE2X+55, bulletE2Y = planeE2Y+140;
    int bulletE3X = planeE3X+55, bulletE3Y = planeE3Y+140;
    int bulletE4X = planeE4X+55, bulletE4Y = planeE4Y+140;
    boolean fire = false;

    public GameWindow3() {
        setVisible(true);
        setSize(1500,1200);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("WindowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("WindowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("WindowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("WindowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("WindowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("WindowDeactivated");
            }
        });
        addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("KeyTyped");
           /* switch(e.getKeyCode())
            {case KeyEvent.VK_R:
                    fire = true;
            break;
            default:
            fire = false;
            break;*/
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KeyPressed");
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    planeY -= 5;
                    bulletY -= 7;
                    planeE1Y += 5;
                    bulletE1Y += 10;
                    planeE2Y += 5;
                    bulletE2Y += 10;
                    planeE3Y += 5;
                    bulletE3Y += 10;
                    if (planeE4Y > 200 && planeE4Y < 900) {
                        planeE4Y += 5;
                        planeE4X += 10;
                    }
                    else
                    {
                        planeE4Y += 5;
                    }
                    bulletE4Y +=10;
                    //fire = true;
                    repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    planeY += 5;
                    bulletY -= 7;
                    planeE1Y += 5;
                    bulletE1Y +=10;
                    planeE2Y += 5;
                    bulletE2Y +=10;
                    planeE3Y += 5;
                    bulletE3Y +=10;
                    if (planeE4Y > 200 && planeE4Y < 900) {
                        planeE4Y += 5;
                        planeE4X += 10;
                    }
                    else
                    {
                        planeE4Y += 5;
                    }
                    bulletE4Y +=10;
                    //fire = true;
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    planeX += 5;
                    bulletY -= 7;
                    planeE1Y += 5;
                    bulletE1Y +=10;
                    planeE2Y += 5;
                    bulletE2Y +=10;
                    planeE3Y += 5;
                    bulletE3Y +=10;
                    if (planeE4Y > 200 && planeE4Y < 900) {
                        planeE4Y += 5;
                        planeE4X += 10;
                    }
                    else
                    {
                        planeE4Y += 5;
                    }
                    bulletE4Y +=10;
                    //fire = true;
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    planeX -= 5;
                    bulletY -= 7;
                    planeE1Y += 5;
                    bulletE1Y +=10;
                    planeE2Y += 5;
                    bulletE2Y +=10;
                    planeE3Y += 5;
                    bulletE3Y +=10;
                    if (planeE4Y > 200 && planeE4Y < 900) {
                        planeE4Y += 5;
                        planeE4X += 10;
                    }
                    else
                    {
                        planeE4Y += 5;
                    }
                    bulletE4Y +=10;
                    //fire = true;
                    repaint();
                case KeyEvent.VK_R:
                    fire = true;
                    repaint();
                    break;
                    default:
                        fire = false;
                        repaint();
                        break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("KeyEvent");
        }
    });
        try {
            background = ImageIO.read( new File("resources/background.png"));
            plane = ImageIO.read( new File("resources/plane4.png"));
            bullet = ImageIO.read( new File("resources/bullet.png"));
            planeE1 = ImageIO.read( new File("resources/plane1.png"));
            bulletE1 = ImageIO.read( new File("resources/bullet.png"));
            planeE2 = ImageIO.read( new File("resources/plane1.png"));
            bulletE2 = ImageIO.read( new File("resources/bullet.png"));
            planeE3 = ImageIO.read( new File("resources/plane1.png"));
            bulletE3 = ImageIO.read( new File("resources/bullet.png"));
            planeE4 = ImageIO.read( new File("resources/plane1.png"));
            bulletE4 = ImageIO.read( new File("resources/bullet.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        repaint();
    }
    public void paint(Graphics g) {
        g.drawImage(background,0,0,1500,1200,null);
        g.drawImage(plane, planeX,planeY,150,150,null);
        g.drawImage(planeE1, planeE1X,planeE1Y,150,150,null);
        g.drawImage(planeE2, planeE2X,planeE2Y,150,150,null);
        g.drawImage(planeE3, planeE3X,planeE3Y,150,150,null);
        g.drawImage(planeE4, planeE4X,planeE4Y,150,150,null);
        if (fire = true) {
            g.drawImage(bullet, bulletX, bulletY, 30, 30, null);
        }
        g.drawImage(bulletE1,bulletE1X,bulletE1Y,30,30,null);
        g.drawImage(bulletE2,bulletE2X,bulletE2Y,30,30,null);
        g.drawImage(bulletE3,bulletE3X,bulletE3Y,30,30,null);
        g.drawImage(bulletE4,bulletE4X,bulletE4Y,30,30,null);
    }
}
