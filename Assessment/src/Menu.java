import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Calendar calendar = Calendar.getInstance();

    public static int getIntegerInput(String message) {
        int number = -1;
        boolean isNumber = false;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                number = input.nextInt();
                isNumber = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input!\nTry again.");
                input.nextLine();
            }
        } while (!isNumber);
        return number;
    }

    public static double getDoubleInput(String message) {
        double number = -1;
        boolean isNumber = false;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                number = input.nextDouble();
                isNumber = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input!\nTry again.");
                input.nextLine();
            }
        } while (!isNumber);
        return number;
    }

    public static String getStringInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        String string = input.nextLine();
        return string;
    }

    private static void printMainMenu() {
        System.out.println("\nMain menu:\n" +
                "0 - Exit\n" +
                "1 - Add client\n" +
                "2 - Update client\n" +
                "3 - Delete client\n" +
                "4 - Add call\n" +
                "5 - Reports\n"
        );
    }

    public static int getOptionFromMainMenu() {
        int option;
        do {
            printMainMenu();
            option = getIntegerInput("Enter an option: ");
            if (option < 0 || option > 5) System.out.println("\nInvalid option!\nTry again.\n");
        } while (option < 0 || option > 5);
        return option;
    }

    private static void printReportsMenu() {
        System.out.println("Reports Menu:\n" +
                "0 - Return\n" +
                "1 - List all clients\n" +
                "2 - List clients with credits less or equal than 0\n" +
                "3 - List clients with credits greater than a value\n" +
                "4 - List client with the greatest credits\n" +
                "5 - Client bill\n"
        );
    }

    public static int getOptionFromReportsMenu() {
        int option;
        do {
            printReportsMenu();
            option = getIntegerInput("Enter an option: ");
            if (option < 0 || option > 6) System.out.println("\nInvalid option!\nTry again.\n");
        } while (option < 0 || option > 6);
        return option;
    }

    private static void printUpdateClientsMenu() {
        System.out.println("0 - Return\n" +
                "1 - Update client name\n" +
                "2 - Update client plan type\n" +
                "3 - Update client credits\n");
    }

    public static int getOptionToUpdateClient() {
        int option;
        do {
            printUpdateClientsMenu();
            option = getIntegerInput("Enter an option: ");
            if (option < 0 || option > 3) System.out.println("\nInvalid option!\nTry again.\n");
        } while (option < 0 || option > 3);
        return option;
    }

    public static String getCellphoneNumber(String message) {
        String cellphoneNumber;
        boolean validNumber = false;
        do {
            cellphoneNumber = String.valueOf(getIntegerInput(message));
            if (cellphoneNumber.length() == 8) validNumber = true;
            else System.out.println("Cellphone number has 8 digits.\n");
        } while (!validNumber);
        return cellphoneNumber;
    }

    public static double getCreditsInput(String message) {
        double credits;
        do {
            credits = Menu.getDoubleInput(message);
            if (credits < 0) System.out.println("Credits has to be greater than 0!\nTry again.\n");
        } while (credits < 0);
        return credits;
    }

    public static Date getDateInput(String message) {
        System.out.println("Please use the pattern: dd/MM/yyyy HH:mm:ss (HH - 24 Hours)");
        String dateToBeParsed;
        Date date = null;
        boolean validDate = false;
        do {
            try {
                dateToBeParsed = getStringInput(message);
                calendar.setTime(simpleDateFormat.parse(dateToBeParsed));
                date = calendar.getTime();
                validDate = true;
            } catch (Exception exception) {
                System.out.println("Invalid date.\nTry again.\n");
            }
        } while (!validDate);
        return date;
    }
}
