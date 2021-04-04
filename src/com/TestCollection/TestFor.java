package com.TestCollection;

import java.util.Scanner;

public class TestFor {

    public static void main(String[] args) {
        Scanner sanner = new Scanner(System.in);
        System.out.print("请输入a:");
        int a = sanner.nextInt();
        System.out.println("请输入b：");
        int b = sanner.nextInt();
        int min_value = (a>b) ? b: a;
        int max_value = (a>b) ? a: b;
        for(int i=min_value;i>1;i--){
            if(a%i==0 && b%i==0){
                System.out.println(i);
                break;
            }
        }
        for(int j=max_value;j<a*b;j++){
            if(j%a==0 && j%b==0){
                System.out.println(j);
                break;
            }
        }
    }
}
