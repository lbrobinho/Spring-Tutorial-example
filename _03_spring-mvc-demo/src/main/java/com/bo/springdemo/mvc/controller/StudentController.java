package com.bo.springdemo.mvc.controller;

import com.bo.springdemo.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        //create a new student object
        Student student = new Student();

        //add student object to the model
        model.addAttribute("student", student);

        // add the country options to the model
        model.addAttribute("theCountryOptions", countryOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student, Model model) {

        System.out.println("student is " + student.getFirstName() + student.getLastName());


        return  "student-confirmation";
    }
}
