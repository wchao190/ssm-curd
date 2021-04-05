package com.array;

public class Student {
    int number;
    int state;
    int score;
    /*构建学生对象数组*/
    public Student[] studentObject(){
        Student[] st = new Student[20];
        for(int i=0; i<st.length; i++){
            st[i] = new Student();
            st[i].number = (i+1);
            st[i].state = (int)(Math.random()*6+1);
            st[i].score = (int)(Math.random()*100+1);
        }
        return st;
    }
    /*打印学生信息*/
    public static void info(Student[] st,int grade){ //int j=0; j<st.length; j++
        for(Student stu : st){
            if(stu.state==grade){
                System.out.println(grade + "年级学生信息："+stu.number+"\t"+stu.state+"\t"+stu.score);
            }
        }
    }
    /*遍历学生数组*/
    public static void xh(Student[] st){  //int k=0; k<st.length; k++
        for(Student std : st){
            System.out.println(std.number+"\t"+std.state+"\t"+std.score);
        }
    }
    /* 按学生成绩从低到高，冒泡排序*/
    public static Student[] scoreSort(Student[] st){
        for(int h=0; h<st.length; h++){
            Student temp;
            for(int m=0; m<st.length -1 -h; m++){
                if(st[m].score>st[m+1].score){
                    temp = st[m];
                    st[m] = st[m+1];
                    st[m+1] = temp;
                }
            }
        }
        return st;
    }
    public static void main(String[] args) {
        Student s = new Student();
        Student[] students = s.studentObject();
        xh(students);
        System.out.println("========================");
        info(students,3);
        System.out.println("========================");
        Student[] newSort = scoreSort(students);
        xh(newSort);
    }
}
