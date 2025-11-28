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
//        studentService.addStudent(student);

        boolean actualResult=listOfStudents.isEmpty(); //false
//        assertTrue(actualResult);

        //lazy
//        assertTrue(()->actualResult); //boolean supplier

//        assertTrue(actualResult,"List of Students is Empty");

//        assertTrue(()->actualResult,"List of Students is empty");

//        assertTrue(actualResult,()->"List of Students is Empty");

        assertTrue(()->actualResult,()->"List of Students is Empty");


    }

    @Test
    public void getStudentsTestUsingAssertFalse(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        List<Student> studentList=studentService.getStudents();
//        studentService.addStudent(student);
        boolean actualResult=studentList.isEmpty();
//        assertFalse(actualResult);

//        assertFalse(actualResult,"Student list should not be empty");

//        assertFalse(()->actualResult);

//        assertFalse(()->actualResult,"Student List should not be empty");

//        assertFalse(actualResult,()->"Student list cannot be empty");

        assertFalse(()->actualResult,()->"Student list cannot be empty");
    }

    @Test
    public void getStudentByIdTestUsingAssertNull(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        studentService.addStudent(student);
        Student actualObject=studentService.getStudentById(1); //fail
//        Student actualObject=studentService.getStudentById(3); //pass

//        assertNull(actualObject);

//        assertNull(actualObject,"Student object is not null");

//        assertNull(actualObject,()->"Student object is not null");


    }

    @Test
    public void getStudentByIdTestUsingAssertNotNull() {
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        studentService.addStudent(student);

//        Student actualObject=studentService.getStudentById(1);
        Student actualObject=studentService.getStudentById(3);

//        assertNotNull(actualObject);

//        assertNotNull(actualObject,"Student object is null");

        assertNotNull(actualObject,()->"Student object is null");


    }

    @Test
    public void getStudentByIdTestUsingAssertEquals(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(1);
//        assertEquals(1,actualObject.getId());

//        assertEquals("bunny",actualObject.getName());

//        assertEquals(student,actualObject);

//        assertEquals(1,actualObject.getId(),"Student ID is not equal");
//        assertEquals(2,actualObject.getId(),"Student ID is not equal"); //false

        assertEquals("bunny",actualObject.getName(),()->"Student name is not found");
//        assertEquals("bun",actualObject.getName(),()->"Student name is not found");
    }



    @Test
    public void getStudentByIdTestUsingAssertNotEquals(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny");
        studentService.addStudent(student);

        Student actualObject=studentService.getStudentById(1);

//        assertNotEquals(1,actualObject.getId());
//        assertNotEquals(3,actualObject.getId());

//        assertNotEquals("bunny",actualObject.getName());
        assertNotEquals("bun",actualObject.getName());

//        assertNotEquals(1,actualObject.getId(),"Student ID are equal");
        assertNotEquals(3,actualObject.getId(),"Student ID are equal");

//        assertNotEquals("bunny",actualObject.getName(),()->"Student names are equal");

        assertNotEquals(student,actualObject);


    }
    }