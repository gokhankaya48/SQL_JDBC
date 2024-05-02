package JDBC_Utilities;

import java.sql.*;
import java.util.ArrayList;

public class DB_Utilities {

    public static Connection baglanti;
    public static Statement sorguEkrani;

    public static ArrayList<ArrayList<String>> getListData(String sorgu) { // public static yaptık çünkü her taraftan çalıştıracağız

        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        try {

            DBConnectionOpen();


            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();

            /* Bu kısım gerekirse açılacak başlangıçta ihtiyacımız yok kolon isimlerine
            ArrayList<String> kolonIsimleri=new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                kolonIsimleri.add(rsmd.getColumnName(i));
            tablo.add(kolonIsimleri);

            */

            // önce tablonun ilk satırına getmetadata ile kolonların isimlerini ekledik
            // bunu da daha satırlardaki hücre değerlerinden önce
            // yukarıdaki iç içe listin ilk satırına ekledik
            // böylece kod çalıştığında önce kolon adlarını daha sonra da hücredeki bilgileri yazdıracak

            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();

                for (int i = 1; i <=rsmd.getColumnCount(); i++) {

                    satir.add(rs.getString(i));
                    // satırdaki elemanları yazdırdığımız kısım

                }

                tablo.add(satir);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        finally {
            DBConnectionClose(); // finally kullanmamızın nedeni try catch e düşse de normal çalışsa da bu kısmı çalıştır demek
            // her iki ihtimalde de connection ı kapatıyoruz.
        }
        return tablo;

    }

    public static void DBConnectionOpen() {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            baglanti = DriverManager.getConnection(url, username, password);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose() {

        try {
            baglanti.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
