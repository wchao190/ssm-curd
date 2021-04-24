package com.sgg.TestThread;

/**
 * 反转字符串
 */
public class StringTest {

    public String reverse(String str,int startIndex,int endIndex){
        String newStr = str.substring(startIndex,endIndex);
        StringBuilder sb = new StringBuilder();
        for(int i=newStr.length()-1;i>=0;i--){
            sb.append(newStr.charAt(i));
        }
        //return new String(sb);
        return sb.toString();
    }
    public static void main(String[] args) {

        String str = "abcdefg";
        String result = new StringTest().reverse(str,1,5);
        System.out.println(result);
    }
}
