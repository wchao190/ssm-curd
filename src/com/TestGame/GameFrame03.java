package com.TestGame;
import com.util.MyFrame;

import java.awt.*;

public class GameFrame03  extends MyFrame {
    private double x=100;
    private double y=100;
    private double degree=3.14/3;
    Image img = GameUtil.getImage("images/sun.jpg");

    public void paint(Graphics g){
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

    public static void main(String[] args) {
        GameFrame03 gf = new GameFrame03();
        gf.launchFrame();
    }
}
