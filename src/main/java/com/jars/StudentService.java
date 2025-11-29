package com.jars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students=new ArrayList<>();

    public List<Student> getStudents(){
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudentById(int studentId){
       return students.stream()
                .filter((student)->student.getId()==studentId)
                .findFirst()
                .orElse(null);
    }
    public String[] getStudentNameListByDepartment(String department){
        return students.stream()
                .filter((student -> student.getDepartment().equals(department)))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public  List<Integer> getStudentIdListByDepartment(String department){
        return students.stream()
                .filter((student -> student.getDepartment().equals(department)))
                .map(Student::getId)
                .collect(Collectors.toList());
    }
    public Student getStudentByName(String name){
        return students.stream()
                .filter((student)->student.getName()==name)
                .findFirst()
                .orElseThrow(()->new StudentNotFoundException("Student Not Found with name : "+name));
    }



}
