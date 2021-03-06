import javax.swing.*;

public class Menu {
    public static String getOptionFromMenu() {
        String option;
        do {
            option = JOptionPane.showInputDialog("0 - Exit" +
                    "\n1 - Addition" +
                    "\n2 - Subtraction" +
                    "\n3 - Multiplication" +
                    "\n4 - Division" +
                    "\n5 - Show Operations History" +
                    "\n\nOption:");
            if (Integer.parseInt(option) < 0 || Integer.parseInt(option) > 5)
                JOptionPane.showMessageDialog(null, "Error: Invalid option. Heading back to the main menu.");

        } while (Integer.parseInt(option) < 0 || Integer.parseInt(option) > 5);

        return option;
    }
}
