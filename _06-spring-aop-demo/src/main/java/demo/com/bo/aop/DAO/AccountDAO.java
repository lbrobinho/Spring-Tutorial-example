package demo.com.bo.aop.DAO;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {

    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with no parameter");
    }

    public void addAccount(Account account) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with parameter");
    }

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT with many parameter");
    }

    //add a new method: findAccount();

    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("no soup for you!!!");
        }

        List<Account> accountList = new ArrayList<>();

        //create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        //add them to account list
        accountList.add(temp1);
        accountList.add(temp2);
        accountList.add(temp3);

        return accountList;
    }
}
