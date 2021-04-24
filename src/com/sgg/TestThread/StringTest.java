package com.sgg.TestThread;

/**
 * 反转字符串
 */
public class StringTest {

    public String reverse(String str,int startIndex,int endIndex){
        String str1 = str.substring(0,startIndex);
        String str3 = str.substring(endIndex);
        String str2 = str.substring(startIndex,endIndex);
        StringBuilder sb = new StringBuilder();
            for(int i=str2.length()-1;i>=0;i--){
            sb.append(str2.charAt(i));
        }
        return str1+sb.toString()+str3;
   }
    public static void main(String[] args) {

        String str = "abcdefg";
        String result = new StringTest().reverse(str,1,5);
        System.out.println(result);
    }
}
