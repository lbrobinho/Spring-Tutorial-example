package com.bo.springdemo.FortuneService;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    // private String fileName = "C:/foobar/fortune-data.txt";
    private String fileName = "/home/bo/workspace/Spring-for-beginner/homework6-bean-scope-annotations/src/main/resources/fortune-data.txt";
    private List<String> theFortunes;

    private Random random = new Random();

    public FileFortuneService() {

        System.out.println(">> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    private void loadTheFortunesFile() {

        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

        File file = new File(fileName);

        System.out.println("Reading fortunes from file: " + file);
        System.out.println("File exists: " + file.exists());

        // initialize array list
        theFortunes = new ArrayList<String>();

        // read fortunes from file
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String tempLine;

            while((tempLine = bufferedReader.readLine()) != null) {
                theFortunes.add(tempLine);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getFortune() {

        int index = random.nextInt(theFortunes.size());

        return theFortunes.get(index);
    }
}
