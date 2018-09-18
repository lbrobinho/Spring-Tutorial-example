package demo.com.bo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* demo.com.bo.aop.DAO.*.*(..))")
    public void forDaoPackage() {}

    //create pointcut for getter method
    @Pointcut("execution(* demo.com.bo.aop.DAO.*.get*(..))")
    public void getter(){}

    //create pointcut for setter method
    @Pointcut("execution(* demo.com.bo.aop.DAO.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
