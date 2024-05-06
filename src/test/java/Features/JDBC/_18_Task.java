package Features.JDBC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _18_Task extends JDBCParent{

    @Test
    public void test18() throws SQLException {

        DBConnectionOpen();

        String query="SELECT first_name, last_name, hire_date\n" +
                "FROM employees\n" +
                "WHERE hire_date < '1990-01-01'\n" +
                "ORDER BY first_name ASC, last_name ASC";

        ResultSet rs= sorguEkrani.executeQuery(query);
        rs.next();
        String firstName=rs.getString(1);
        String lastName=rs.getString(2);

        Assert.assertEquals(firstName,"Aamer");
        Assert.assertEquals(lastName,"Azuma");

        DBConnectionClose();

    }
}
