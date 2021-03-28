package com.TestGame;
import java.awt.*;

public class Star {
    Image img;
    double x,y;
    double width,height;
    public void draw(Graphics g){
        g.drawImage(img,(int)x,(int)y,null);
    }
    public Star(Image img){
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    public Star(Image img,double x,double y){
        this(img);
        this.x = x;
        this.y = y;
    }
    /*
    * 构造函数，传入图片路径，返回图片
    * */
    public Star(String imgPath,double x,double y){
        this(GameUtil.getImage(imgPath),x,y);   // 调用本类中其他构造方法，避免重复写width、height；
    }
    public Star(){
    }
}
