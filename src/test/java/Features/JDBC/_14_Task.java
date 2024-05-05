package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _14_Task extends JDBCParent {

    @Test
    public void task14() throws SQLException {

        DBConnectionOpen();

        String query="select employees.first_name, employees.last_name, max(salaries.salary) as 'yuksek_maas' , departments.dept_name from employees\n" +
                "left join salaries ON employees.emp_no=salaries.emp_no\n" +
                "left join dept_emp ON dept_emp.emp_no=employees.emp_no\n" +
                "left join departments ON departments.dept_no=dept_emp.dept_no\n" +
                "where dept_name='Sales'\n" +
                "group by employees.emp_no\n" +
                "order by yuksek_maas desc\n" +
                "LIMIT 1";
        ResultSet rs= sorguEkrani.executeQuery(query);

        rs.next();
        int sorguSonucu=rs.getInt(3);

        Assert.assertEquals(sorguSonucu, 158220, "salaries are not equal.");








        DBConnectionClose();

    }
}
