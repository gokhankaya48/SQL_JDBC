package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Task extends JDBCParent {
    @Test
    public void _06_Task() throws SQLException {
        DBConnectionOpen();
        ResultSet sonucTablosu = sorguEkrani.executeQuery("SELECT dept_emp.dept_no, employees.first_name, employees.last_name, salaries.salary\n" +
                "FROM salaries \n" +
                "LEFT JOIN employees ON employees.emp_no = salaries.emp_no\n" +
                "LEFT JOIN dept_emp ON dept_emp.emp_no = employees.emp_no\n" +
                "LEFT JOIN departments ON dept_emp.dept_no = departments.dept_no\n" +
                "WHERE salaries.salary >= 70000 AND departments.dept_no = 'd007'");
        int i = 0;
        while (sonucTablosu.next() && i != 20) {
            i++;
            System.out.print(sonucTablosu.getString("first_name"));
            System.out.println();
        }
        DBConnectionClose();

    }
}
