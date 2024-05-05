package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _17_Task extends JDBCParent{

    @Test
    public void task17() throws SQLException {

        DBConnectionOpen();

        String query="SELECT dept_name, first_name, last_name, average_salary\n" +
                "FROM (\n" +
                "    SELECT d.dept_name, e.first_name, e.last_name, AVG(s.salary) AS average_salary\n" +
                "    FROM departments d\n" +
                "    JOIN dept_emp de ON d.dept_no = de.dept_no\n" +
                "    JOIN employees e ON e.emp_no = de.emp_no\n" +
                "    JOIN salaries s ON s.emp_no = e.emp_no\n" +
                "    GROUP BY e.emp_no\n" +
                "    ORDER BY average_salary DESC\n" +
                ") AS new_table\n" +
                "GROUP BY dept_name\n" +
                "ORDER BY MAX(average_salary) DESC";

        ResultSet rs=sorguEkrani.executeQuery(query);
        rs.next();
        double maxAvgSalary=rs.getDouble(4);
        System.out.println("maxAvgSalary = " + maxAvgSalary);
        rs.last();
        double lowestAvgSalary=rs.getDouble(4);
        System.out.println("lowestAvgSalary = " + lowestAvgSalary);


        Assert.assertEquals(maxAvgSalary,141835.3333);
        Assert.assertEquals(lowestAvgSalary,108155.8235);



        DBConnectionClose();


    }
}
