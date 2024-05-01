package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _10_Task extends JDBCParent{
    @Test
    public void _10_Task() throws SQLException {
        DBConnectionOpen();
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select salaries.emp_no, salaries.salary, salaries.from_date, salaries.to_date from salaries where salaries.emp_no='10102'");

        while (sonucTablosu.next()) {
            System.out.print(sonucTablosu.getString("emp_no"));
            System.out.print(" ");
            System.out.println(sonucTablosu.getString("salary"));

        }
        DBConnectionClose();


    }
}
