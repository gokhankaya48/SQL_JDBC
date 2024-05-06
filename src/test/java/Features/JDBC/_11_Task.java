package Features.JDBC;

import JDBC_Utilities.DB_Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _11_Task extends JDBCParent {

    @Test
    public void test11() throws SQLException {


        DBConnectionOpen();

        ResultSet rs= sorguEkrani.executeQuery("select salaries.emp_no, salaries.salary, salaries.to_date from salaries where salaries.emp_no='10102' order by salary ASC");
        rs.next();
        String ilkMaas=rs.getString(2);
        System.out.println(rs.getString(2));
        rs.last();
        String sonMaas=rs.getString(2);
        System.out.println(rs.getString(2));

        Assert.assertEquals(ilkMaas,"43915","İlk maaş eşit değil");
        Assert.assertEquals(sonMaas,"61059","Son maaş eşit değil");

        DBConnectionClose();

    }
}
