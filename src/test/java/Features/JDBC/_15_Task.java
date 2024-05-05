package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _15_Task extends JDBCParent{

    @Test
    public void task15() throws SQLException {

        String query="select employees.emp_no, employees.first_name, employees.last_name, avg(salaries.salary) as 'ortalama_maas' , departments.dept_name from employees\n" +
                "left join salaries ON employees.emp_no=salaries.emp_no\n" +
                "LEFT JOIN dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "LEFT JOIN departments ON dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_name='Research'\n" +
                "group by departments.dept_name\n" +
                "order by ortalama_maas DESC\n" +
                "LIMIT 1";

        DBConnectionOpen();
        ResultSet rs= sorguEkrani.executeQuery(query);
        rs.next();
        System.out.println("rs.getString(4) = " + rs.getString(4));
        double ortResearchSalary=rs.getDouble(4);
        Assert.assertEquals(ortResearchSalary,59665.1817, "amount is not equals with expected");

        DBConnectionClose();



    }
}
