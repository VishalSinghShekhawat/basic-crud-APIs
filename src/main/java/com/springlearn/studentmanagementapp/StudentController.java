package com.springlearn.studentmanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController         //----> It ensures that the called API comes here(understand as a target for APIs) and we
                       // will write all our APIs in this class

public class StudentController {

 HashMap<Integer,Student> db = new HashMap<>();

// @GetMapping("/getStudent")                        //----> URL:- ______.com/getStudent?regNo = 179&name = Vishal
// public Student getStudent(@RequestParam("regNo") int regNo, @RequestParam("name") String name){
//     return db.get(regNo);
// }

    @GetMapping("/getStudent")      //Get API annotation           //----> URL:- ______.com/getStudent?regNo = 179
    public Student getStudent(@RequestParam("regNo") int regNo){  //RequestParam to take variable as input
        return db.get(regNo);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){ //RequestBody to take object as input
        if(db.containsKey(student.getReg())){
            return "Student already added";
        }else{
            db.put(student.getReg(), student);
            return "Student added successfully";
        }
    }

    @GetMapping("/getStudent/{regNo}")       //----> work similar as RequestParam   URL:- _____.com/getStudent/179
    public Student getStudentByPath(@PathVariable("regNo") int regNo){  //RequestParam to take variable as input
        return db.get(regNo);
    }

    @PutMapping("/updateAge/{newAge}")
    public Student updateStudent(@RequestParam("regNo") int regNo, @PathVariable("newAge") int newAge){
        db.get(regNo).setAge((newAge));
        return db.get(regNo);
    }
}
