package com.plane;

import com.util.Constant;

import java.awt.*;

/*定义子弹属性*/
public class Bullet {
    double x,y;
    int speed=3;
    double degree;
    int width=10;
    int height=10;
    public Bullet(){
        degree = Math.random()*Math.PI*2;
        this.x = Constant.GAME_WIDTH/2;
        this.y = Constant.GAME_HEIGHT/2;
    }
    /*获取子弹矩形*/
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
    /*画子弹*/
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval((int)x,(int)y,width,height);
        if(y>Constant.GAME_HEIGHT || y<0){
            degree = -degree;  //角度反转
        }
        if(x>Constant.GAME_WIDTH || x<0){
            degree = Math.PI -degree;
        }
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        g.setColor(c); // 还原颜色
    }
}
