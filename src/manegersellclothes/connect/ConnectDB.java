
package manegersellclothes.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection JDBC_CONECTION() {
        final String Url = "jdbc:jtds:sqlserver://LAPTOP-8NH1CHAP:1433/quanlyquanao;instance=SQLEXPRESS;user=sa;password=12345";
        //final String user = "root";
        //final String password = "19032002az";
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(Url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }
    
}
