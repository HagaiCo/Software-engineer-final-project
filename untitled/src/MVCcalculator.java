public class MVCcalculator {

    public static void main(String[] args)
    {
        CalculationView theView = new CalculationView();
        CalculationModel theModel = new CalculationModel();

        CalculatorController controller = new CalculatorController(theModel, theView);

        theView.setVisible(true);
    }
}
