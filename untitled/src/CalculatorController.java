import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculationView theView;
    private CalculationModel theModel;


    public CalculatorController(CalculationModel theModel, CalculationView theView)
    {
        this.theModel = theModel;
        this.theView = theView;

        this.theView.addCalculationListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumber = 0, secondNumber = 0;

            try
            {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                theModel.addTwoNumbers(firstNumber, secondNumber);
                theView.setCalcSolution(theModel.getCalculationValue());
            }
            catch(NumberFormatException ex)
            {
                theView.errorDisplay("איפה תלך ?!");
            }
        }
    }
}
