package com.springlearn.studentmanagementapp;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Repository   // Tell spring that this is our Repository class and all the logics related to database are written here
public class StudentRepository {

    HashMap<Integer,Student> db = new HashMap<>();

    public Student getStudent1(int regNo){  //RequestParam to take variable as input
        return db.get(regNo);
    }

    public String addStudent(Student student){ //RequestBody to take object as input
        if(db.containsKey(student.getReg())){
            return "Student already added";
        }else{
            db.put(student.getReg(), student);
            return "Student added successfully";
        }
    }

    public Student getStudentByPath(int regNo){  //RequestParam to take variable as input
        return db.get(regNo);
    }

    public Student updateStudent(int regNo,int newAge){
        db.get(regNo).setAge((newAge));
        return db.get(regNo);
    }

    public int delete(int regNo){
        if(!db.containsKey(regNo))
            return 0;

        db.remove(regNo);
        return 1;
    }

    public int deleteByPath(int regNo){
        if(!db.containsKey(regNo))
            return 0;

        db.remove(regNo);
        return 1;
    }

    public Student changeCourse(int regNo,String course){
        if(!db.containsKey(regNo))
            System.out.println("Student doesn't exist");

        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student changeCourse1(int regNo,String course){
        if(!db.containsKey(regNo))
            System.out.println("Student doesn't exist");

        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student changeCourse2(int regNo, String course){
        if(!db.containsKey(regNo))
            System.out.println("Student doesn't exist");

        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student changeCourseAndAge(int regNo,Student s){
        if(!db.containsKey(regNo))
            System.out.println("Student doesn't exist");

        db.put(regNo,s);
        return db.get(regNo);
    }
}
