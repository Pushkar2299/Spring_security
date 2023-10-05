package com.example.demo.Controller;

import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1,"Pankaj Kumar"),
            new Student(2,"Ashish Raman"),
            new Student(3,"Suraj Singh")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent (@PathVariable("studentId") Integer studentId){
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + studentId + "does not exist"));

    }
}
