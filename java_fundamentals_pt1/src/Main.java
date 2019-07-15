import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double number1;
        double number2;
        double result;

        String option = optionsMenu();

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        switch (option) {
            case "0":
                JOptionPane.showMessageDialog(null, "Bye.");
                break;
            case "1":
                number1 = getNumberUserInput();
                number2 = getNumberUserInput();
                result = addition(number1, number2);
                JOptionPane.showMessageDialog(null, "Result: " + decimalFormat.format(result));
                break;
            case "2":
                number1 = getNumberUserInput();
                number2 = getNumberUserInput();
                result = subtraction(number1, number2);
                JOptionPane.showMessageDialog(null, "Result: " + decimalFormat.format(result));
                break;
            case "3":
                number1 = getNumberUserInput();
                number2 = getNumberUserInput();
                result = multiplication(number1, number2);
                JOptionPane.showMessageDialog(null, "Result: " + decimalFormat.format(result));
                break;
            case "4":
                number1 = getNumberUserInput();
                number2 = getNumberUserInput();
                if (number2 == 0) JOptionPane.showMessageDialog(null,
                        "Error: Can't happen a division by zero.");
                else {
                    result = division(number1, number2);
                    JOptionPane.showMessageDialog(null, "Result: " +
                            decimalFormat.format(result));
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option.");
                break;
        }
    }

    public static String optionsMenu() {
        String option = JOptionPane.showInputDialog("0 - Exit" +
                "\n1 - Addition" +
                "\n2 - Subtraction" +
                "\n3 - Multiplication" +
                "\n4 - Division" +
                "\n\nOption:");

        return option;
    }

    public static double getNumberUserInput() {
        double number = Double.parseDouble(JOptionPane.showInputDialog("Input a number: "));
        return number;
    }

    public static double addition(double x, double y) {
        return x + y;
    }

    public static double subtraction(double x, double y) {
        return x - y;
    }

    public static double multiplication(double x, double y) {
        return x * y;
    }

    public static double division(double x, double y) {
        return x / y;
    }
}
