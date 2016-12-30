import controllers.*;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllerManager;
import controllers.scenes.GameScene;
import controllers.scenes.MenuScene;
import controllers.scenes.PlayGameScene;
import controllers.scenes.SceneListener;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.Vector;

import static utils.Utils.loadImage;

// Data abstraction

/**
 * Created by apple on 11/30/16.
 */
public class GameWindow extends Frame implements Runnable, SceneListener {



    BufferedImage backBuffer;
    GameScene currentScene;
    Stack<GameScene> gameSceneStack;

    public GameWindow() {
        gameSceneStack = new Stack<>();
        //currentScene = new MenuScene();
        this.replaceScene(new MenuScene(),false);
        configSettings();
        setVisible(true);
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
        backBuffer = new BufferedImage(GameSetting.instance.getWidth(),GameSetting.instance.getHeight(),BufferedImage.TYPE_INT_ARGB);


        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

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
                System.out.println( " keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                currentScene.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });
    }

    public void replaceScene(GameScene newScene, boolean addToBackStack){
        if(addToBackStack && currentScene != null){
            gameSceneStack.push(currentScene);
        }
        currentScene = newScene;
        currentScene.setSceneListener(this);
    }

    public void back(){
        if(!gameSceneStack.isEmpty()){
            currentScene = gameSceneStack.pop();
        }
    }

    private void configSettings() {
        PlaneController.instance.keySetting = new KeySetting(
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_SPACE
        );

    }


    //Utilities


    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        currentScene.update(backBufferGraphics);
        g.drawImage(backBuffer,0,0,GameSetting.instance.getWidth(),GameSetting.instance.getHeight(),null);
    }

    @Override
    public void run() {
        while (true){
            this.repaint();
            try {
                Thread.sleep(17);
                currentScene.run();
                currentScene.destroy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
