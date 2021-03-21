package com.TestTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 * 可视化日期
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入一个日期：");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date d = df.parse(temp);
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            int currentDt = c.get(Calendar.DATE);
            c.set(Calendar.DATE,1);
            int maxValue = c.getActualMaximum(Calendar.DATE);
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for(int j=1;j<c.get(Calendar.DAY_OF_WEEK);j++){
                System.out.print("\t");
            }
            for(int i=1;i<=maxValue;i++){
                if(c.get(Calendar.DATE)==currentDt){
                    System.out.print("*");
                }
                System.out.print(i+"\t");
                if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                    System.out.println();
                }
                c.add(Calendar.DATE,1);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}

