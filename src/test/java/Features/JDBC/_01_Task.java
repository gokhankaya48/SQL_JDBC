package Features.JDBC;
//1. List all employees in department D001.
//- D001 departmanındaki tüm çalışanları listele.

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Task extends JDBCParent{
    @Test
    public void task01() throws SQLException {
        DBConnectionOpen();

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from employees.dept_emp where dept_no='d001'");
        int i=0;

        while(sonucTablosu.next() && i!=20){
            i++;
            System.out.println(sonucTablosu.getString("emp_no"));

        }
        DBConnectionClose();

    }

}
