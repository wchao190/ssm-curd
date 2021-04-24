package com.sgg.TestThread;

/**
 * 获取一个字符串在另一个字符串中出现的次数
 */
public class StringTest01 {
    public int geTCount(String str,String subStr){
        int strLength = str.length();
        int subLength = subStr.length();
        int count=0;
        int index;
        if(strLength>=subLength){
            while ((index=str.indexOf(subStr)) != -1){
                count ++;
                str = str.substring(index + subLength);
            }
            return count;
        }else{
            return 0;
        }
    }
    //方式二
    public int geTCount2(String str,String subStr){
        int strLength = str.length();
        int subLength = subStr.length();
        int count=0;
        int index=0;
        if(strLength>=subLength){
            while ((index=str.indexOf(subStr,index)) != -1){
                count ++;
                index += subLength;
            }
            return count;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        String str1 = "absdfgfabsafghgaab3456256adfgbaabbaaab";
        String str2 = "ab";
        int count = new StringTest01().geTCount2(str1,str2);
        System.out.println(count);
    }
}
