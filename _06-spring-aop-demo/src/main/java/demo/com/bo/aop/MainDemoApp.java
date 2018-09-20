package demo.com.bo.aop;

import demo.com.bo.aop.DAO.Account;
import demo.com.bo.aop.DAO.AccountDAO;
import demo.com.bo.aop.DAO.MembershipAccountDAO;
import demo.com.bo.aop.config.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        Account account = new Account();

        accountDAO.addAccount(account, true);

        String name = account.getName();
        String level = account.getLevel();

        membershipAccountDAO.addSillyMember();

        //call method to find the accounts
        List<Account> accountList = accountDAO.findAccounts(false);

        //display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");
        System.out.println(accountList);
        System.out.println("\n");

        //close the context
        context.close();
    }
}
