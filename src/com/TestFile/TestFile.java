package com.TestFile;
import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        File f = new File("C:/Users/wuc/Desktop/11.xlsx");
        File f2 = new File("C:/Users/wuc/Desktop/");
        File f3 = new File("C:/Users/wuc/Desktop/test.text");
        if(f.isFile()){
            System.out.println("这是一个文件");
        }
        if(f2.isDirectory()){
            System.out.println("这是一个目录");
        }
        if(f.exists()){
            System.out.println("文件存在");
        }
        if(f.canRead()){
            System.out.println("文件存在");
        }
        System.out.println(f.getName());
        System.out.println(f.getPath());
        try{
            f3.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        File f4 = new File("C:/Users/wuc/Desktop/test.text");
        f3.delete();
        File f5 = new File("C:/Users/wuc/Desktop/aa/bb");
        f5.mkdirs();
    }
}
