package com.TestGame;
import com.util.Constant;
import com.util.MyFrame;

import java.awt.*;

public class SolarFrame extends MyFrame {
    Image img = GameUtil.getImage("images/bg.jpg");
    Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);  //太阳
    Planet earth = new Planet("images/Earth.jpg",150,100,0.1,sun);  //地球
    Planet mars = new Planet("images/Mars.jpg",200,150,0.15,sun);
    public void paint(Graphics g){

        g.drawImage(img,0,0,null);
        sun.draw(g);
        earth.draw(g);
        earth.drawTrace(g,earth,Color.magenta);
        mars.draw(g);
        mars.drawTrace(g,mars,Color.CYAN);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }

}
