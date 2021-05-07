package com.sgg;
/**
 * 图片加解密
 */

import java.io.*;

public class TestBuffer {
    public void copyBuffer(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            FileInputStream fr = new FileInputStream(new File("src\\com\\sgg\\10.jpg"));
            FileOutputStream fw = new FileOutputStream(new File("src\\com\\sgg\\12.jpg"),true);
            bis = new BufferedInputStream(fr);
            bos = new BufferedOutputStream(fw);
            byte[] buffer = new byte[512];
            int len;
            while ( (len = bis.read(buffer)) != -1){
                for(int i=0;i<len;i++){
                    buffer[i] = (byte)(buffer[i]^5);
                }
                bos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyBuffer2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fr = new FileInputStream(new File("src\\com\\sgg\\12.jpg"));
            FileOutputStream fw = new FileOutputStream(new File("src\\com\\sgg\\13.jpg"), true);
            bis = new BufferedInputStream(fr);
            bos = new BufferedOutputStream(fw);
            byte[] buffer = new byte[512];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new TestBuffer().copyBuffer2();
    }
}
