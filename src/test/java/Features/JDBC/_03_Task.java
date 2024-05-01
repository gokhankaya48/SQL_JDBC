package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_Task extends JDBCParent{
    @Test
    public void _03_Task() throws SQLException {
        DBConnectionOpen();

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select avg(salaries.salary) from employees.salaries");
        sonucTablosu.next();
        System.out.println(sonucTablosu.getString("avg(salaries.salary)"));
        DBConnectionClose();
    }
}
