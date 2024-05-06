package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _19_Task extends JDBCParent{

    @Test
    public void Task19() throws SQLException {

        DBConnectionOpen();

        String query="SELECT first_name, last_name, hire_date\n" +
                "FROM employees\n" +
                "WHERE hire_date BETWEEN '1985-01-01' AND '1989-12-31'\n" +
                "ORDER BY hire_date ASC";

        ResultSet rs=sorguEkrani.executeQuery(query);
        rs.next();
        String hireDate=rs.getString(3);

        Assert.assertEquals(hireDate,"1985-01-01");

        DBConnectionClose();
    }
}
