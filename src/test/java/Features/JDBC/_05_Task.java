package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_Task extends JDBCParent{
    @Test
    public void _05_Task() throws SQLException {
        DBConnectionOpen();

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select avg(salary) from employees.salaries left join employees ON employees.emp_no=salaries.emp_no\n" +
                "where employees.gender='F'");
        sonucTablosu.next();
        System.out.println(sonucTablosu.getString("avg(salary)"));
    }
}
