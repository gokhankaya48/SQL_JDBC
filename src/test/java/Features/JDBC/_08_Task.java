package Features.JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _08_Task extends JDBCParent{
    @Test
    public void _08_Task() throws SQLException {
        DBConnectionOpen();
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select dept_emp.dept_no, avg(salaries.salary) from salaries \n" +
                "left join employees ON employees.emp_no=salaries.emp_no\n" +
                "left join dept_emp ON dept_emp.emp_no=employees.emp_no\n" +
                "group by dept_no");
        int i=0;
        while (sonucTablosu.next()&&i!=20){
            i++;
            System.out.print(sonucTablosu.getString("dept_no"));
            System.out.print(" ");
            System.out.println(sonucTablosu.getString("avg(salaries.salary)"));
        }


        DBConnectionClose();
    }
}
