package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _07_Task extends JDBCParent{
    @Test
    public void _07_Task() throws SQLException {
        DBConnectionOpen();
        ResultSet sonucTablosu = sorguEkrani.executeQuery("SELECT distinct(employees.first_name) FROM salaries\n" +
                "LEFT JOIN employees ON employees.emp_no = salaries.emp_no\n" +
                "where salaries.salary between 50000 and 100000");
        int i=0;
        while (sonucTablosu.next()&&i!=20){
            i++;
            System.out.println(sonucTablosu.getString("first_name"));
        }


    }
}
