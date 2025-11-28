package com.jars.assertions;

import com.jars.Student;
import com.jars.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);

        boolean actualResult=listOfStudents.isEmpty(); //false
        assertTrue(actualResult);
    }

}