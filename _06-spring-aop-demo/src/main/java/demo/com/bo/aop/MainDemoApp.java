package demo.com.bo.aop;

import demo.com.bo.aop.DAO.AccountDAO;
import demo.com.bo.aop.DAO.MembershipAccountDAO;
import demo.com.bo.aop.config.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read the configure file into bean factory
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from context
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipAccountDAO membershipAccountDAO
                = context.getBean("membershipAccountDAO", MembershipAccountDAO.class);

        //call the business method
        accountDAO.addAccount();

        membershipAccountDAO.addSillyMember();

        //close the context
        context.close();
    }
}
