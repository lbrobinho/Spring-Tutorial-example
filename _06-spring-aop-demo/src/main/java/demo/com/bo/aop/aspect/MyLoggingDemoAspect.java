package demo.com.bo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

        @Before("demo.com.bo.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
        public void logtoCloudAsync() {
            System.out.println("\n=====>>> Logging to cloud in async fashion");
        }
}
