package com.TestGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/*
* 根据path，获取一张图片
* */
public class GameUtil {
    public static Image getImage(String path){
        URL url = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try{
            img = ImageIO.read(url);
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }
}
