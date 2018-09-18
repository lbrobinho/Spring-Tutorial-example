package demo.com.bo.aop.aspect;

import demo.com.bo.aop.DAO.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect {


//    @Before("execution(public void add*())")
    @Before("demo.com.bo.aop.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        //display the method arguments
        Object[] args = joinPoint.getArgs();

        //loop thru args
        for (Object o : args) {
            System.out.println(o);

            if(o instanceof Account) {

                //downcast and print Account specific stuff
                Account account = (Account) o;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut ="execution(* demo.com.bo.aop.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n======>>>> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("\n======>>>> result is: " + result);
    }
}
