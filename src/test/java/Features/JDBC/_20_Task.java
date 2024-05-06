package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _20_Task extends JDBCParent{

    @Test
    public void task20() throws SQLException {

        DBConnectionOpen();

        String query="SELECT \n" +
                "    employees.first_name,\n" +
                "    employees.last_name,\n" +
                "    employees.hire_date,\n" +
                "    salaries.salary\n" +
                "FROM \n" +
                "    employees\n" +
                "left join\n" +
                "    dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "left join\n" +
                "    salaries ON employees.emp_no = salaries.emp_no\n" +
                "left join\n" +
                "    departments ON dept_emp.dept_no = departments.dept_no\n" +
                "WHERE \n" +
                "    employees.hire_date BETWEEN '1985-01-01' AND '1989-12-31'\n" +
                "    AND departments.dept_name = 'Sales'\n" +
                "ORDER BY \n" +
                "    salaries.salary DESC";

        ResultSet rs= sorguEkrani.executeQuery(query);
        rs.next();
        String firstName=rs.getString(1);
        String lastName=rs.getString(2);

        Assert.assertEquals(firstName,"Tokuyasu");
        Assert.assertEquals(lastName,"Pesch");


        DBConnectionClose();
    }

}
