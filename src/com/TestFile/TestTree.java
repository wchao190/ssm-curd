package com.TestFile;
import java.io.File;

/**
 * 递归打印目录
 */
public class TestTree {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\wuc\\Desktop\\aa");
        printLevel(f,0);
    }
    static void printLevel(File f,int level){
        for(int i=0;i<level;i++){   //一级目录传进来，level初始值=0，所以没有下划线；
            System.out.print("-");  //一级目录没有下划线，二级目录一个下划线，三级目录二个下划线，一次类推...
        }
        System.out.println(f.getName());   //打印目录的名字；
        if(f.isDirectory()){               //判断是否是目录，是目录继续循环；
            File[] files = f.listFiles();  //获取目录下所有的目录；
            for(File j : files){          //循环目录
                printLevel(j,level+1);  //每循环一次，目录等级加1；
            }
        }
    }
}
