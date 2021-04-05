package com.array;
/**
 * 杨辉三角
 * */
public class YangHui {
    public static void main(String[] args) {
        int[][] yangHui = new int[10][];
        for(int i=0;i<yangHui.length;i++){
            yangHui[i] = new int[i+1];          //一维数组的元素是一个数组，长度不定
            yangHui[i][0] = yangHui[i][i] = 1;  //收尾都是1
            for(int m=1;m<yangHui[i].length-1;m++){  //为中间部分赋值，
                yangHui[i][m] = yangHui[i-1][m-1] + yangHui[i-1][m];
            }
        }

        for(int j=0;j<yangHui.length;j++){
            for(int k=0;k<=j;k++){
                System.out.print(yangHui[j][k]+"\t");
            }
            System.out.println();
        }
    }
}
