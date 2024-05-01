package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Task extends JDBCParent{
    @Test
    public void _04_Task() throws SQLException {
        DBConnectionOpen();
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select avg(salary) from employees.salaries \n" +
                "left join employees ON employees.emp_no=salaries.emp_no\n" +
                "where employees.gender='M'");

        sonucTablosu.next();
        System.out.println(sonucTablosu.getString("avg(salary)"));
        DBConnectionClose();

    }
}
