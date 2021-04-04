package com.TestCollection;
/*
* 质数只能被1和它自己整除；
* */
public class TestFor3 {
    public static void main(String[] args) {
        for(int i=2;i<=100;i++){
            boolean flag=true;
            for(int j=2;j<i;j++){  //循环除以小于它自己的数
                if(i % j == 0){
                    flag=false;   //只要余数为0，就不是质数
                    break;        //只要确定是质数，就停止循环
                }
            }
            if(flag){
                System.out.println(i);
            }
        }
    }
}
