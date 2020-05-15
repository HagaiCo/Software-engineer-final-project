import java.net.URL;
import java.sql.*;

public class MVCcalculator {

    public static void main(String[] args)
    {
        new MVCcalculator().DBTest();
        CalculationView theView = new CalculationView();
        CalculationModel theModel = new CalculationModel();

        CalculatorController controller = new CalculatorController(theModel, theView);

        theView.setVisible(true);
    }
    void DBTest()
    {
        String user = "postgres";
        String pass = "Yeswecan2015";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try
        {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            String sql = "Select * from project";
            ResultSet resStatement = stm.executeQuery(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }


    }
}