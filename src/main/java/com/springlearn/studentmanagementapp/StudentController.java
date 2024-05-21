package com.springlearn.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController         //----> It ensures that the called API comes here(understand as a target for APIs) and we
                       // will write all our APIs in this class
@RequestMapping("/student")    //Use to give common endpoint in all APIs "/get" will be called as "/student/get"
public class StudentController {

 @Autowired
 StudentService sS;

 @Autowired
 StudentRepository sR1;

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
        System.out.println("Repo Bean in controller class: " + sR1); //----> Statement is used to show that @Autowired
                             // creates single object in entire application even when name is changed(not possible in
                             // with "new" keyword)
        System.out.println("Service bean in controller class: "+ sS);
        return sS.addStudent(student);
    }

    @GetMapping("/get/{regNo}")       //----> work similar as RequestParam   URL:- _____.com/getStudent/179
    public ResponseEntity getStudentByPath(@PathVariable("regNo") int regNo){  //RequestParam to take variable as input
        Student s =  sS.getStudentByPath(regNo);
        if(s == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(s, HttpStatus.FOUND);
        }
    }

    @PutMapping("/updateAge/{r}")
    public ResponseEntity updateStudent(@RequestParam("q") int regNo, @PathVariable("r") int newAge){
        Student s = sS.updateStudent(regNo, newAge);
        if(s == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(s, HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("q") int regNo){
        int ans = sS.delete(regNo);

        if(ans == 0){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity("Student deleted Successfully", HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/delete/{q}")
    public ResponseEntity deleteByPath(@PathVariable("q") int regNo){
        int ans = sS.deleteByPath(regNo);

        if(ans == 0){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity("Student deleted Successfully", HttpStatus.FOUND);
        }
    }

    @PutMapping("/changeCourse")
    public ResponseEntity changeCourse(@RequestParam("q") int regNo,@RequestParam("r") String course){
        Student student =  sS.changeCourse(regNo, course);

        if(student == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(student, HttpStatus.FOUND);
        }
    }

    @PutMapping("/changeCourse/{q}/{r}")
    public ResponseEntity changeCourse1(@PathVariable("q") int regNo,@PathVariable("r") String course){
        Student student = sS.changeCourse1(regNo, course);

        if(student == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(student, HttpStatus.FOUND);
        }
    }

    @PutMapping("/changeCourse/{q}")
     public ResponseEntity changeCourse2(@PathVariable("q") int regNo,@RequestParam("r") String course){
            Student student = sS.changeCourse2(regNo, course);

        if(student == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(student, HttpStatus.FOUND);
        }
    }

    @PutMapping("/changeCourseAndAge")
    public ResponseEntity changeCourseAndAge(@RequestParam("q") int regNo,@RequestBody Student s){
        Student student = sS.changeCourseAndAge(regNo, s);

        if(regNo != s.getReg()){
            return new ResponseEntity("Student regNo doesn't match with given regNo", HttpStatus.NOT_ACCEPTABLE);
        }else if(student == null){
            return new ResponseEntity("Student doesn't exist", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(student, HttpStatus.FOUND);
        }
    }

}
