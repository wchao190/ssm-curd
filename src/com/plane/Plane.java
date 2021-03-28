package com.plane;
import com.TestGame.GameUtil;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

/*
* 实现飞机画面、移动
* */
public class Plane {
    Image img;
    double x,y;
    boolean left,right,up,down;
    private boolean alive=true;
    double speed=10;
    int width,height;
    public Plane(){
    }
    public Plane(String imgPath,double x,double y){
        this.img = GameUtil.getImage(imgPath);
        this.x = x;
        this.y = y;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    /*获取飞机矩形*/
    public Rectangle getRect(){
        Rectangle r = new Rectangle((int)x,(int)y,width,height);
        return r;
    }
    /*画飞机*/
    public void draw(Graphics g){
        if(alive){
            g.drawImage(img,(int)x,(int)y,null);
            move();
        }
    }
    /*移动键盘*/
    public void move(){
        if(left){
            x -= speed;
        }
        if(right){
            x += speed;
        }
        if(up){
            y -= speed;
        }
        if(down){
            y += speed;
        }
    }
    /*增加键盘*/
    public void addDirec(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            default:
                break;
        }
    }
    /*减少键盘方向*/
    public void lessDirec(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            default:
                break;
        }
    }
    public void setAlive(boolean val){
        this.alive=val;
    }
    public boolean getAlive(){
        return this.alive;
    }
}
