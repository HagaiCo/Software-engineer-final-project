import java.awt.event.ActionListener;
import javax.swing.*;
public class CalculationView extends JFrame {
    private JTextField firstNumber = new JTextField(10);
    private JLabel additionalLabel = new JLabel("+");
    private JTextField secondNumber = new JTextField(10);
    private JButton calculationButton = new JButton("חשב");
    private JTextField calcsolution = new JTextField(10);

    CalculationView()
    {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);


        calcPanel.add(firstNumber);
        calcPanel.add(additionalLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calculationButton);
        calcPanel.add(calcsolution);

        this.add(calcPanel);
    }

    public int getFirstNumber()
    {
        return Integer.parseInt(firstNumber.getText());
    }
    public int getSecondNumber()
    {
        return Integer.parseInt(secondNumber.getText());
    }
    public int getcalcSolution()
    {
        return Integer.parseInt(calcsolution.getText());
    }
    public void setCalcSolution(int solution)
    {
        calcsolution.setText(Integer.toString(solution));
    }
    void addCalculationListener(ActionListener actionListener)
    {
        calculationButton.addActionListener(actionListener);
    }
    void errorDisplay(String e)
    {
        JOptionPane.showMessageDialog(this, e);
    }

}
