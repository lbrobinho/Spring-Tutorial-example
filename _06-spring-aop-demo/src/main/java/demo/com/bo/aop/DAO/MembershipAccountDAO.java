package demo.com.bo.aop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipAccountDAO {

    public boolean addSillyMember() {

        System.out.println(getClass() + ": DOING MY membership WORK: ADDING AN ACCOUNT");

        return true;
    }
}
