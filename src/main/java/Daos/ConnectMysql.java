package Daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysql {
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/thimodule3";
        String user="root";
        String pwd="123@123a";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, pwd);
        }catch(Exception e){
            return null;
        }
    }
}
