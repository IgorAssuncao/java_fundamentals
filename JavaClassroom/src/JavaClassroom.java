import java.util.Scanner;

public class JavaClassroom {
    public static void main(String[] args) {
        final int SIZE = 100;
        final int END = 0;
        Student[] classroom = new Student[SIZE];
        int studentsQuantity = 0;
        int option = getOptionFromMenu();

        while(option != END) {
            switch (option) {
                case 1:
                    createStudentInArray(classroom);
                    break;
                case 2:
                    readStudentsArray(classroom, studentsQuantity);
                    break;
//                case 3:
//                    update();
//                    break;
//                case 4:
//                    delete();
//                    break;
                default:
                    break;
            }
            option = getOptionFromMenu();
        }

    }

    public static void printMenu() {
        System.out.println("Menu");
        System.out.println("0 - Exit");
        System.out.println("1 - Create");
        System.out.println("2 - Read");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
    }

    public static int getOptionFromMenu() {
        int option;

        do {
            printMenu();
            option = inputNumber("Enter an option: ");

            if ((option < 0) || (option > 4)) System.out.println("Error: Invalid option!\n");
        } while ((option < 0) || (option > 4));

        return option;
    }

    public static int inputNumber(String message) {
        int number = 0;
        boolean isNumber = false;
        Scanner userInput = new Scanner(System.in);

        do {
            try {
                System.out.print(message);
                number = userInput.nextInt();
                isNumber = true;
            } catch (Exception exception) {
                System.out.println("Error: NaN!\n");
                userInput.nextLine();
            }
        } while(!isNumber);

        return number;
    }

    public static String inputStudentName() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Student\'s name: ");

        return userInput.nextLine();
    }

    public static void createStudentInArray(Student[] classroom, int studentsQuantity) {
        String studentName = inputStudentName();
        int grade1 = inputNumber("Enter with a grade: ");
        int grade2 = inputNumber("Enter with a grade: ");

        classroom[studentsQuantity] = new Student(studentName, grade1, grade2);
    }

    public static void readStudentsArray(Student[] classroom, int studentsQuantity) {
        System.out.println("Printing students");

        for (int index = 0; index < studentsQuantity; index++) {
            System.out.println(classroom[index]);
        }
    }
}
}
