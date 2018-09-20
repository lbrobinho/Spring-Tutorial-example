package demo.com.bo.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {

        //simulate a delay

        try {

            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        //return a fortune
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {

        //simulate a delay

        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed");
        }

        //return a fortune
        return getFortune();
    }
}
