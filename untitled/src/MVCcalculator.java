import java.net.URL;
import java.sql.*;

public class MVCcalculator {

    public static void main(String[] args)
    {
        new DBCreation().DBCreate();
        CalculationView theView = new CalculationView();
        CalculationModel theModel = new CalculationModel();

        CalculatorController controller = new CalculatorController(theModel, theView);

        theView.setVisible(true);
    }
}