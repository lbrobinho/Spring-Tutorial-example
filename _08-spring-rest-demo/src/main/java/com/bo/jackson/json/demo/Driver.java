package com.bo.jackson.json.demo;

import com.bo.jackson.json.demo.entity.Address;
import com.bo.jackson.json.demo.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {

            //create object mapper
            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and map/convert to JAVA POJO
            Student student = mapper.readValue(
                    new File("data/sample-full.json"), Student.class);

            //print firstName and lastName
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());

            Address address = student.getAddress();

            System.out.println(address.getStreet());
            System.out.println(address.getCity());

            for (String tempLang : student.getLanguages()) {
                System.out.println(tempLang);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
