package com.springlearn.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController         //----> It ensures that the called API comes here(understand as a target for APIs) and we
                       // will write all our APIs in this class
@RequestMapping("/student")    //Use to give common endpoint in all APIs "/get" will be called as "/student/get"
public class StudentController {

 @Autowired
 StudentService sS;

//    @GetMapping("/getStudent")                        //----> URL:- ______.com/getStudent?regNo = 179&name = Vishal
//    public Student getStudent(@RequestParam("regNo") int regNo, @RequestParam("name") String name){
//        return db.get(regNo);
//    }


    @GetMapping("/get")      //Get API annotation           //----> URL:- ______.com/getStudent?regNo = 179
    public Student getStudent1(@RequestParam("q") int regNo){  //RequestParam to take variable as input
        return sS.getStudent1(regNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){ //RequestBody to take object as input
        return sS.addStudent(student);
    }

    @GetMapping("/get/{regNo}")       //----> work similar as RequestParam   URL:- _____.com/getStudent/179
    public Student getStudentByPath(@PathVariable("regNo") int regNo){  //RequestParam to take variable as input
        return sS.getStudentByPath(regNo);
    }

    @PutMapping("/updateAge/{r}")
    public Student updateStudent(@RequestParam("q") int regNo, @PathVariable("r") int newAge){
        return sS.updateStudent(regNo, newAge);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("q") int regNo){
        return sS.delete(regNo);
    }

    @DeleteMapping("/delete/{q}")
    public String deleteByPath(@PathVariable("q") int regNo){
        return sS.deleteByPath(regNo);
    }

    @PutMapping("/changeCourse")
    public Student changeCourse(@RequestParam("q") int regNo,@RequestParam("r") String course){
        return sS.changeCourse(regNo, course);
    }

    @PutMapping("/changeCourse/{q}/{r}")
    public Student changeCourse1(@PathVariable("q") int regNo,@PathVariable("r") String course){
        return sS.changeCourse1(regNo, course);
    }

    @PutMapping("/changeCourse/{q}")
     public Student changeCourse2(@PathVariable("q") int regNo,@RequestParam("r") String course){
            return sS.changeCourse2(regNo, course);
    }

    @PutMapping("/changeCourseAndAge")
    public Student changeCourseAndAge(@RequestParam("q") int regNo,@RequestBody Student s){
        return sS.changeCourseAndAge(regNo, s);
    }

}
