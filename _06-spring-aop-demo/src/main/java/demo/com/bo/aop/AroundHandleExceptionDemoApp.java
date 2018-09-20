package demo.com.bo.aop;

import demo.com.bo.aop.config.DemoConfig;
import demo.com.bo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        //read the configure file into bean factory
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from context
        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);


        logger.info("calling getFortune");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);

        logger.info("data is: " + data);

        logger.info("finished");

        //close the context
        context.close();
    }
}
