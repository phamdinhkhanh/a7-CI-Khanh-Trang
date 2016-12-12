package Controller;

/**
 * Created by laptopTCC on 12/12/2016.
 */
public class KeySetting {
    public int keyUp;
    public int keyDown;
    public int keyRight;
    public int keyLeft;

    public KeySetting(int keyUp, int keyDown, int keyRight, int keyLeft) {
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public int getKeyDown() {
        return keyDown;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

}
