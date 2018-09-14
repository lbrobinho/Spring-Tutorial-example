package demo.com.bo.aop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
