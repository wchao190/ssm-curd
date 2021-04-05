package com.array;

public class Test03 {
    public static void main(String[] args) {
        int[] n = new int[6];
        for(int i=0;i<n.length;i++){
            n[i] =  (int)(Math.random()*30 + 1);
            for(int k=0; k<i; k++){
                if(n[i] == n[k]){  //将当前值与前面的逐一比较
                    i--;
                    break;
                }
            }
        }
        for(int j=0;j<n.length;j++)
            System.out.println(n[j]);
    }
}
