package demo.com.bo.aop.DAO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Account {

    private String name;

    private String level;

    public Account() {
    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
