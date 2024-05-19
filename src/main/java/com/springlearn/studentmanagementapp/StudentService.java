package com.springlearn.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service       // Used to tell spring ki it is our service class and this is the class where all the logics are written
public class StudentService {


    //In this particular project we don't have any logic to write that's why it is looking similar to controller
    //class but logic like (100<regNo<500) or (course = "CSE" & Age <= 18) all these must be written here only.
    @Autowired  //----> Used to make objects without using "new" Keyword
    StudentRepository sR;

    public Student getStudent1(int regNo){  //RequestParam to take variable as input
        return sR.getStudent1(regNo);
    }

    public String addStudent(Student student){ //RequestBody to take object as input
        return sR.addStudent(student);
    }

    public Student getStudentByPath(int regNo){  //RequestParam to take variable as input
        return sR.getStudentByPath(regNo);
    }

    public Student updateStudent(int regNo, int newAge){
       return sR.updateStudent(regNo, newAge);
    }

    public String delete(int regNo){
       return sR.delete(regNo);
    }

    public String deleteByPath(int regNo){
       return sR.deleteByPath(regNo);
    }

    public Student changeCourse(int regNo,String course){
        return sR.changeCourse(regNo, course);
    }

    public Student changeCourse1(int regNo, String course){
       return sR.changeCourse1(regNo, course);
    }

    public Student changeCourse2(int regNo, String course){
       return sR.changeCourse2(regNo, course);
    }

    public Student changeCourseAndAge(int regNo, Student s){
        return sR.changeCourseAndAge(regNo, s);
    }
}
