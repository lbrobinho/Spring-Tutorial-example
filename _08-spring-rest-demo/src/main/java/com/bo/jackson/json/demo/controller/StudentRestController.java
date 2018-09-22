package com.bo.jackson.json.demo.controller;

import com.bo.jackson.json.demo.entity.AnotherStudent;
import com.bo.jackson.json.demo.exception.StudentErrorResponse;
import com.bo.jackson.json.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<AnotherStudent> anotherStudentList;

    @PostConstruct
    public void loadData() {

        anotherStudentList = new ArrayList<>();

        anotherStudentList.add(new AnotherStudent("Poornima", "Patel"));
        anotherStudentList.add(new AnotherStudent("Mario", "Rossi"));
        anotherStudentList.add(new AnotherStudent("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<AnotherStudent> getStudents() {

        return anotherStudentList;
    }

    @GetMapping("/students/{studentId}")
    public AnotherStudent getStudent(@PathVariable int studentId) {

        if ( (studentId >= anotherStudentList.size()) || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }


        return anotherStudentList.get(studentId);

    }


}
