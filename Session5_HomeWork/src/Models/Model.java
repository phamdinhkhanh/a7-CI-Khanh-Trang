package Models;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by laptopTCC on 12/6/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;
    private int hp;
    private int atk;
    private int def;


    public Model(int x, int y, int width, int height,int hp, int atk, int def) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int dx,int dy){
        this.x += dx;
        this.y += dy;
    }
    public int getMidX(){
        return this.x+this.width/2;
    }
    public int getMidY(){
        return this.y+this.height/2;
    }
    public int getButtom(){
        return this.y+height;
    }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    public boolean intersects(Model other){
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = other.getRect();
        return rect1.intersects(rect2);
    }

    public void atk(Model other){
        int dam;
        if(this.intersects(other) && this.getAtk() > other.getDef()){
            dam = this.getAtk() - other.getDef();
            other.hp -= dam;
        } else if(this.intersects(other) && this.getAtk() < other.getDef()){
            dam = -this.getAtk() + other.getDef();
            this.hp -= dam;
        }
    }

    public boolean isAlive(){
        if(this.hp < 0){
            return false;
        } else {
            return true;
        }
    }
}
