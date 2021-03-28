package com.TestGame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame02 extends Frame {
    private double x=100;
    private double y=100;
    private double degree=3.14/3;
    public void launchFrame(){
        new PaintThread().start();
        setSize(500,500);
        setLocation(200,200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public  void paint(Graphics g){
        Image img = GameUtil.getImage("images/sun.jpg");
        g.drawImage(img,(int)x,(int)y,null);
        if(y>500-30 || y<0){
            degree = -degree;
        }
        if(x>500-30 || x<0){
            degree = Math.PI -degree;
        }
        x += 3*Math.cos(degree);
        y += 3*Math.sin(degree);
    }

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
        GameFrame02 gf =  new GameFrame02();
        gf.launchFrame();
    }
}
