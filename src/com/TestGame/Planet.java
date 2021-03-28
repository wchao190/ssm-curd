package com.TestGame;
import java.awt.*;

/*创建行星*/
public class Planet extends Star {
    /*
    行星沿着椭圆运行：长轴、短轴、速度；
    * */
    double longAxis;
    double shortAxis;
    double speed;
    Star center;
    double degree;
    String imgPath;

    public Planet(String imgPath,double longAxis,double shortAxis,double speed,Star center){
        super(GameUtil.getImage(imgPath));
        this.x = (center.x + this.width/2) + longAxis;  // 行星起点x坐标：太阳左上角x坐标+图片宽度的一半
        this.y = (center.y + this.height/2);            // 行星起点y坐标：太阳左上角y坐标+图片高度的一半
        this.longAxis = longAxis;  //定义椭圆长半轴
        this.shortAxis = shortAxis;  //定椭圆短半轴
        this.speed = speed;
        this.center = center;
        this.imgPath = imgPath;
    }
    public Planet(Image img, double x, double y){
        super(img,x,y);
    }
    public Planet(String imgPath, double x, double y){
        super(imgPath,x,y);
    }
    /*移动行星*/
    public void draw(Graphics g){
        super.draw(g);
        move();
    }
    /*行星移动的角度*/
    public void move(){
        x = center.x + longAxis*Math.cos(degree);
        y = center.y + shortAxis*Math.sin(degree);
        degree +=speed;
    }
    /*画行星轨迹*/
    public void drawTrace(Graphics g,Star p,Color color){
        double ovalX,ovalY,ovalWidth,ovalHeight;
        ovalX=(center.x+center.width/2)-longAxis-p.height/2; //太阳中心坐标等于=起点坐标+宽高/2，减去椭圆矩形半轴，减去行星的宽高/2;
        ovalY=(center.y+center.height/2)-shortAxis-p.width/2;
        ovalWidth = 2*longAxis;
        ovalHeight = 2*shortAxis;
        Color c = g.getColor();
        g.setColor(color);
        g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth,(int)ovalHeight);
    }
}
