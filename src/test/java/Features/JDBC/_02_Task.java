package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Task extends JDBCParent {
    @Test
    public void _02_Task() throws SQLException {
        DBConnectionOpen();

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from employees.dept_emp where dept_no='d003'");
        int i = 0;

        while (sonucTablosu.next() && i != 20) {
            i++;

            System.out.println(sonucTablosu.getString("emp_no"));


        }
        DBConnectionClose();

    }
}
