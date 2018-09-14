package demo.com.bo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

//    @Before("execution(public void add*())")
    @Before("execution(public * add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("Executing @Before advice on addAccount()");
    }
}
