package com.springlearn.studentmanagementapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementAppApplicationTests {

	@Autowired
	StudentService sS;

	@BeforeEach
	public void prepare(){
		sS.addStudent(new Student(1,"MEA","dummy",22));
		sS.addStudent(new Student(2,"MEA","dummy2",22));
		sS.addStudent(new Student(3,"MEA","dummy3",22));
	}
	@Test
	public void addStudentTest(){
		Student dummy = new Student(236,"MEA","Nitish",22);
		sS.addStudent(dummy);

		Student expectedOutput = new Student(236,"MEA","Nitish",22);
		Student actualOutput = sS.getStudent1(236);

		Assertions.assertEquals(expectedOutput.getReg(), actualOutput.getReg());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void getStudent(){
		Student expectedOutput = new Student(2,"MEA","dummy2",22);
		Student actualOutput = sS.getStudent1(2);

		Assertions.assertEquals(expectedOutput.getReg(), actualOutput.getReg());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
	}

}
