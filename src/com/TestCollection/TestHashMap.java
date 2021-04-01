package com.TestCollection;
import java.util.ArrayList;
public class TestHashMap {
    //一个对象对应一条记录
    public static void main(String[] args) {
        MyMap mp1 = new MyMap(0301,"高淇",3000,"项目部","2007-10");
        MyMap mp2 = new MyMap(0302,"马士兵",4000,"教学部","2006-10");
        ArrayList<MyMap> list = new ArrayList<MyMap>();
        list.add(mp1);
        list.add(mp2);
        printInfo(list);
    }
    public static void printInfo(ArrayList<MyMap> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }

    }
}
