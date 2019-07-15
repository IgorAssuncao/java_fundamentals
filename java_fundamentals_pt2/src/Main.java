import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double result;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        Calculator calculator = new Calculator();

        Menu menu = new Menu();
        String option = menu.getOptionFromMenu();

        while (!(option.equals("0"))) {
            calculator.setX(getNumberUserInput());
            calculator.setY(getNumberUserInput());

            switch (option) {
                case "1":
                    result = calculator.addition(calculator.getX(), calculator.getY());
                    JOptionPane.showMessageDialog(null, "Addition result: " + decimalFormat.format(result));
                    break;
                case "2":
                    result = calculator.subtraction(calculator.getX(), calculator.getY());
                    JOptionPane.showMessageDialog(null, "Subtraction result: " + decimalFormat.format(result));
                    break;
                case "3":
                    result = calculator.multiplication(calculator.getX(), calculator.getY());
                    JOptionPane.showMessageDialog(null, "Multiplication result: " + decimalFormat.format(result));
                    break;
                case "4":
                    if (calculator.getY() == 0) JOptionPane.showMessageDialog(null,
                            "Error: Can't happen a division by zero.");
                    else {
                        result = calculator.division(calculator.getX(), calculator.getY());
                        JOptionPane.showMessageDialog(null, "Division result: " +
                                decimalFormat.format(result));
                    }
                    break;
                default:
                    break;
            }

            option = menu.getOptionFromMenu();
        }

        JOptionPane.showMessageDialog(null, "Exiting! Bye.");
    }

    public static double getNumberUserInput() {
        double number = Double.parseDouble(JOptionPane.showInputDialog("Input a number: "));
        return number;
    }
}
