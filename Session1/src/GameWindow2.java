import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.layout.Background;
import javax.imageio.ImageIO;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;


/**
 * Created by laptopTCC on 12/1/2016.
 */
public class GameWindow2 extends Frame {
    public Image background,plane,planeE;
    public Image bullet;
    public int planeX = 700, planeEX = 500, planeBulletX = 730;
    public int planeY = 550, planeEY = 50, planeBulletY = 535;
    public GameWindow2() {
        setVisible(true);
        setSize(1500, 1200);
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
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane = ImageIO.read(new File ("resources/plane3.png"));
            planeE = ImageIO.read(new File ("resources/plane1.png"));
            bullet = ImageIO.read(new File ("resources/bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("KeyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_UP:
                        planeY = planeY-5;
                        planeEY = planeEY+5;
                        planeBulletY = planeBulletY-10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY = planeY+5;
                        planeEY = planeEY+5;
                        planeBulletY = planeBulletY-10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX = planeX-5;
                        planeEY = planeEY+5;
                        planeBulletY = planeBulletY-10;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX = planeX+5;
                        planeEY = planeEY+5;
                        planeBulletY = planeBulletY-10;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("KeyReleased");
                }
        });
        repaint();
    }
    public void paint(Graphics g) {
        g.drawImage(background,0,0,1500,1200,null);
        g.drawImage(plane,planeX, planeY, 70,70,null);
        g.drawImage(planeE, planeEX, planeEY, 60,60,null);
        g.drawImage(bullet,planeBulletX,planeBulletY,10,10,null);
    }
}
