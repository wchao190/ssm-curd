package com.plane;

import com.TestGame.GameUtil;
import com.util.Constant;
import com.util.MyFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.Date;

public class PlaneGameFrame extends MyFrame {
    Image img = GameUtil.getImage("images/bg.jpg");
    Plane p = new Plane("images/plane.png",200,200);
    ArrayList bulletList = new ArrayList();
    Date startTime;
    Date endTime;
    Explode ex;
    public void paint(Graphics g){
        g.drawImage(img,0,0,null);
        p.draw(g);
        for(int j=0;j<bulletList.size();j++){
            Bullet b = (Bullet)bulletList.get(j);
            b.draw(g);
            /*检查飞机子弹碰撞*/
            boolean peng = b.getRect().intersects(p.getRect());  //判断两个矩形是否相交，返回一个布尔值
            if(peng){
                p.setAlive(false);
                if(ex==null){
                    ex = new Explode(p.x,p.y);
                    endTime = new Date();
                }
                ex.draw(g);
                break;
            }
        }
        /*打印信息*/
        if(!p.getAlive()){
            printInfo(g,Color.white,30,"Game Over!",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
            long period = (endTime.getTime() - startTime.getTime())/1000;
            printInfo(g,Color.magenta,20,period+"秒",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2-100);
        }
    }
    public void printInfo(Graphics g,Color color,int s,String str,int x,int y){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体",Font.BOLD,s);
        g.setFont(f);
        g.drawString(str, x,y);
        g.setColor(c);
    }
    /*重写父类的launchFrame方法*/
    @Override
    public void launchFrame() {
        super.launchFrame();
        //添加键盘监听
        addKeyListener(new KeyMonitor());

        //生成一堆子弹
        for (int i=0;i<=30;i++){
            Bullet b = new Bullet();
            bulletList.add(b);
        }
        startTime = new Date();
    }

    /*定义内部类，操作键盘*/
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {   //按下键盘
            System.out.println("按下" + e.getKeyCode());  //获取按键信息
            p.addDirec(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {  //释放键盘
            System.out.println("按下" + e.getKeyCode());  //获取按键信息
            p.lessDirec(e);
        }
    }
    public static void main(String[] args) {
        PlaneGameFrame gf = new PlaneGameFrame();
        gf.launchFrame();
    }
}
