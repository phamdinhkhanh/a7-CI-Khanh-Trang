package controllers.scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/30/2016.
 */
public abstract class GameScene {
    protected SceneListener sceneListener;
    protected PlaneDestroyListener planeDestroyListener;

    public void GameScene(PlaneDestroyListener planeDestroyListener) {
        this.planeDestroyListener = planeDestroyListener;
    }

    public void setSceneListener(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public abstract void update(Graphics g);
    public abstract void run();
    public abstract void keyPressed(KeyEvent e);
    public abstract void destroy();
}
