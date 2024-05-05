package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _12_Task extends JDBCParent{

    @Test
    public void task12() throws SQLException {

        String query="select salaries.emp_no, employees.first_name, employees.last_name, max(salaries.salary) as 'en yüksek maaş' from salaries \n" +
                "left join employees ON employees.emp_no=salaries.emp_no";

        DBConnectionOpen();
        ResultSet rs= sorguEkrani.executeQuery(query);

        rs.next();
        int maas=rs.getInt(4);
        System.out.println("maas = " + maas);
        Assert.assertEquals(maas, 158220,"Values are not equals.");
        


        DBConnectionClose();


    }


}
