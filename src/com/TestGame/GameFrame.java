package com.TestGame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameFrame  extends Frame {
    /*
    加载窗口
    * */
    private int x=100;
    private int y=100;
    public void launchFrame(){
        new PaintThread().start(); //启动重画线程
        setSize(500,500);
        setLocation(100,100);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    //画图，重写父类方法
    public void paint(Graphics g){
        Font f = new Font("华文楷体",Font.BOLD,20);
        g.setFont(f);
        g.drawLine(100,100,200,200);
        g.drawRect(100,100,200,200);
        g.drawString("欢迎学习java",200,200);
        g.drawOval(100,100,200,200);
        g.fillRect(100,100,20,20);
        g.setColor(Color.BLUE);
        g.fillOval(200,200,40,40);
        Image img = GameUtil.getImage("images/12.jpg");
        g.drawImage(img,x,y,null);
        x+=1;
        y+=1;
    }

    //定义重画窗口内部类
    class PaintThread extends Thread{
        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }
}
