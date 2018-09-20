package demo.com.bo.aop.aspect;

import demo.com.bo.aop.AroundHandleExceptionDemoApp;
import demo.com.bo.aop.DAO.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect {

    private  Logger logger = Logger.getLogger(getClass().getName());

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

        //let's post-process the data .. let's modify it : -

        //convert account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n======>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        //loop through accounts

        for (Account account : result) {

            String upperName = account.getName().toUpperCase();

            //update the name on the account
            account.setName(upperName);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* demo.com.bo.aop.DAO.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint, Throwable theExc) {

        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @AfterThrowing on method: " + method);


        //log the exception
        System.out.println("\n===>>> THe exception is: " + theExc);
    }

    @After("execution(* demo.com.bo.aop.DAO.AccountDAO.findAccounts(..))")
    public void afterTFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @After (finally) on method: " + method);


    }

    @Around("execution(* demo.com.bo.aop.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===>>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {

            logger.warning(e.getMessage());

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - start;

        System.out.println("\n====> duration is " + duration / 1000.0);

        return result;
    }
}
