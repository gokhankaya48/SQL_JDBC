package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _13_Task extends JDBCParent{

    @Test
    public void task13() throws SQLException {

        DBConnectionOpen();

        String query="select salaries.emp_no, employees.first_name, employees.last_name, salaries.salary, max(salaries.to_date) from salaries \n" +
                "left join employees ON employees.emp_no=salaries.emp_no\n" +
                "group by employees.emp_no";

        ResultSet rs= sorguEkrani.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();


        rs.last();
        int lastRow=rs.getRow();
        System.out.println("lastRow = " + lastRow);
        String maasSutunuAdi=rsmd.getColumnName(5);
        System.out.println("maasSutunuAdi = " + maasSutunuAdi);

        Assert.assertEquals(lastRow, 300023,"all employees can't listed.");
        Assert.assertEquals(maasSutunuAdi, "max(salaries.to_date)");

        DBConnectionClose();
    }
}
