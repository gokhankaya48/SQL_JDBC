package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _16_Task extends JDBCParent{

    @Test
    public void task16() throws SQLException {

        DBConnectionOpen();

        String query="SELECT d.dept_name AS department, e.first_name, e.last_name, MAX(s.salary) AS max_salary\n" +
                "FROM employees e\n" +
                "INNER JOIN dept_emp de ON e.emp_no = de.emp_no\n" +
                "INNER JOIN departments d ON de.dept_no = d.dept_no\n" +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "GROUP BY d.dept_name\n" +
                "ORDER BY max_salary DESC";

        ResultSet rs= sorguEkrani.executeQuery(query);
        rs.next();
        String maxSalary=rs.getString(4);
        System.out.println("maxSalary = " + maxSalary);
        rs.last();
        String lowestSalary=rs.getString(4);
        System.out.println("lowestSalary = " + lowestSalary);

        Assert.assertEquals(maxSalary,"158220");
        Assert.assertEquals(lowestSalary,"130211");

        DBConnectionClose();
    }
}
