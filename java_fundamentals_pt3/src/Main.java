import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double result;
        final int HISTORY_SIZE = 5;
        final int QUANTITY_SIZE = 4;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        Calculator calculator = new Calculator();

        String option = Menu.getOptionFromMenu();

        Log logArray = new Log(HISTORY_SIZE, QUANTITY_SIZE);
        String[] logHistory = logArray.getOperationsHistory();

        while (!(option.equals("0"))) {
            if (option.equals("5")) {
                JOptionPane.showMessageDialog(null, logArray);
            } else {
                calculator.setX(getNumberUserInput());
                calculator.setY(getNumberUserInput());
                switch (option) {
                    case "1":
                        result = calculator.addition(calculator.getX(), calculator.getY());
                        logArray.insert(logHistory, '+', calculator.getX(), calculator.getY(), result);
                        JOptionPane.showMessageDialog(null, "Addition result: " + decimalFormat.format(result));
                        break;
                    case "2":
                        result = calculator.subtraction(calculator.getX(), calculator.getY());
                        logArray.insert(logHistory, '-', calculator.getX(), calculator.getY(), result);
                        JOptionPane.showMessageDialog(null, "Subtraction result: " + decimalFormat.format(result));
                        break;
                    case "3":
                        result = calculator.multiplication(calculator.getX(), calculator.getY());
                        logArray.insert(logHistory, '*', calculator.getX(), calculator.getY(), result);
                        JOptionPane.showMessageDialog(null, "Multiplication result: " + decimalFormat.format(result));
                        break;
                    case "4":
                        if (calculator.getY() == 0) JOptionPane.showMessageDialog(null,
                                "Error: Can't happen a division by zero.");
                        else {
                            result = calculator.division(calculator.getX(), calculator.getY());
                            logArray.insert(logHistory, '/', calculator.getX(), calculator.getY(), result);
                            JOptionPane.showMessageDialog(null, "Division result: " +
                                    decimalFormat.format(result));
                        }
                        break;
                    default:
                        break;
                }
            }
            option = Menu.getOptionFromMenu();
        }

        JOptionPane.showMessageDialog(null, "Exiting! Bye.");
    }

    public static double getNumberUserInput() {
        double number = 0;
        boolean running = true;

        while (running) {
            try {
                number = Double.parseDouble(JOptionPane.showInputDialog("Input a number: "));
                running = false;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "It has to be a valid number.");
            }
        }
        return number;
    }
}