package com.springlearn.studentmanagementapp;

public class Student {

    private int reg;

    private String course;

   private String name;

    private int age;

    private Month birthMonth = Month.JANUARY;        //---> Just to show ENUM application

    public Student() {
    }

    public Student(int reg, String course, String name, int age) {
        this.reg = reg;
        this.course = course;
        this.name = name;
        this.age = age;
    }

    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "reg=" + reg +
                ", course='" + course + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthMonth=" + birthMonth +
                '}';
    }
}
