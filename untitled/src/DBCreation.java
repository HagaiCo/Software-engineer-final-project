import java.sql.*;
import java.sql.*;

public class DBCreation
{


    void DBCreate()
    {
    String user = "postgres";
    String pass = "Yeswecan2015";
    String url = "jdbc:postgresql://localhost:5432/final_project";
    try
    {
        System.out.println("Connecting to a selected database...");
        Connection connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected database successfully...");

        Statement stm = connection.createStatement();
        String sql = "create database final_project";

        int resStatement = stm.executeUpdate(sql);

        //while (resStatement.next())
       // {
           // System.out.println(resStatement.getString("productname"));
      //  }
        connection.close();
    }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
