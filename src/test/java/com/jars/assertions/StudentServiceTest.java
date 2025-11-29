package com.jars.assertions;

import com.jars.Student;
import com.jars.StudentNotFoundException;
import com.jars.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    public void getStudentIdListByDepartmentTestUsingAssertIterableEquals() {
        StudentService studentService = new StudentService();
        Student student1 = new Student(1, "bunny", "Computer Science");
        Student student2 = new Student(2, "alice", "Computer Science");
        Student student3 = new Student(3, "bob", "Mathematics");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

        List<Integer> expectedIds = List.of(1, 2);
        List<Integer> actualIds = studentService.getStudentIdListByDepartment("Computer Science");

        assertIterableEquals(expectedIds, actualIds, "Student IDs should match for Computer Science department");
    }

    @Test
    public void getStudentNameListByDepartmentTestUsingAssertIterableEquals() {
        StudentService studentService = new StudentService();
        Student student1 = new Student(1, "bunny", "Computer Science");
        Student student2 = new Student(2, "alice", "Computer Science");
        Student student3 = new Student(3, "bob", "Mathematics");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

//        String[] expectedNames = {"bunny", "alice"};
        List<String> expectedNames = List.of("bun", "alice");

//        List<String> expectedNames = List.of("bun", "alice");
        String[] actualNames = studentService.getStudentNameListByDepartment("Computer Science");

        assertIterableEquals(expectedNames, Arrays.stream(actualNames).toList(), "Student names should match for Computer Science department");

    }

    @Test
    public void getStudentNameListByDepartmentTestUsingAssertArrayEquals() {
        StudentService studentService = new StudentService();
        Student student1 = new Student(1, "bunny", "Computer Science");
        Student student2 = new Student(2, "alice", "Computer Science");
        Student student3 = new Student(3, "bob", "Mathematics");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);

        String[] expectedNames = {"bunny", "alice"};
//        List<String> expectedNames = List.of("bun", "alice");
        String[] actualNames = studentService.getStudentNameListByDepartment("Computer Science");

        assertArrayEquals(expectedNames,actualNames, "Student names should match for Computer Science department");

    }





    @Test
    public void getStudentByNameTestUsingAssertThrows(){
        StudentService studentService=new StudentService();
        Student student=new Student(1,"bunny","cse");
        studentService.addStudent(student);

//        assertThrows(StudentNotFoundException.class,()->{
////            studentService.getStudentByName("bunny");
//            studentService.getStudentByName("bun");
//        });

//        assertThrows(NullPointerException.class,()->{
//            studentService.getStudentByName("bun");
//        });


//        assertThrows(StudentNotFoundException.class,()->{
////            studentService.getStudentByName("bunny");
//            studentService.getStudentByName("bun");
//        },"StudentNotFoundException should be thrown but it wasn't");

//        assertThrows(StudentNotFoundException.class,()->{
//            studentService.getStudentByName("bunny");
//        },()->"StudentNotFoundException should be thrown but it wasn't");

  assertThrows(RuntimeException.class,()->{
            studentService.getStudentByName("bunn");
//            studentService.getStudentByName("bunny"); //fails
        },()->"StudentNotFoundException should be thrown but it wasn't");


    }
    }