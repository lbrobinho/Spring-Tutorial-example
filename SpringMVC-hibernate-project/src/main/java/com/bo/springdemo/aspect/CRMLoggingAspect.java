package com.bo.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.bo.springdemo.Controller.*.*(..)))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.bo.springdemo.dao.*.*(..)))")
    private void forDaoPackage() {

    }

    @Pointcut("execution(* com.bo.springdemo.service.*.*(..)))")
    private void forServicePackage() {

    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFLow() {}

    //add @Before advice
    @Before("forAppFLow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();

        logger.info("@Before calling method:" + method);

        //get the arguments
        Object[] args = joinPoint.getArgs();

        //loop through and display args
        for (Object arg : args) {
            logger.info("===>> argument: " + arg);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFLow()",
                    returning = "result")
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("@AfterReturning calling method:" + method);

        logger.info("result: " + result);
    }
}
