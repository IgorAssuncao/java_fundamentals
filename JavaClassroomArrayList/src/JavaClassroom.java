import java.util.ArrayList;
import java.util.Scanner;

public class JavaClassroom {
    public static void main(String[] args) {
        final int END = 0;
        ArrayList<Student> classroom = new ArrayList<>();
        int option = getOptionFromMenu();

        while(option != END) {
            switch (option) {
                case 1:
                    createStudentInArray(classroom);
                    break;
                case 2:
                    printStudentsArray(classroom);
                    break;
                case 3:
                    updateStudentInArray(classroom);
                    break;
                case 4:
                    deleteStudentInArray(classroom);
                    break;
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

    public static void createStudentInArray(ArrayList<Student> classroom) {
        String studentName = inputStudentName();
        int grade1 = inputNumber("Enter with a grade: ");
        int grade2 = inputNumber("Enter with a grade: ");

        if (getNameIndexInArrayList(classroom, studentName) == -1) classroom.add(new Student(studentName, grade1, grade2));
    }

    public static void printStudentsArray(ArrayList<Student> classroom) {
        System.out.println("Printing students");

        if (classroom.isEmpty()) {
            System.out.println("Classroom is empty!");
            return;
        }

        for (Student student: classroom) {
            System.out.println(student);
        }
    }

    public static int getNameIndexInArrayList(ArrayList<Student> classroom, String studentName) {
        int index = -1;
        for (int i = 0; i < classroom.size(); i++) {
            if (studentName.toUpperCase().equals(classroom.get(i).getName().toUpperCase())) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static boolean checkClassroomEmptyness(ArrayList<Student> classroom) {
        if (classroom.isEmpty()) {
            System.out.println("Empty classroom");
            return true;
        }

        return false;
    }

    public static void updateStudentInArray(ArrayList<Student> classroom) {
        if (checkClassroomEmptyness(classroom)) return;

        printStudentsArray(classroom);

        String studentName = inputStudentName();

        int index = getNameIndexInArrayList(classroom, studentName);

        if (index == -1) {
            System.out.println("Error: Name not found!");
            return;
        }

        classroom.get(index).setGrade1(inputNumber("Enter with a grade: "));
        classroom.get(index).setGrade2(inputNumber("Enter with a grade: "));
    }

    public static void deleteStudentInArray(ArrayList<Student> classroom) {
        if (checkClassroomEmptyness(classroom)) return;

        printStudentsArray(classroom);

        String studentName = inputStudentName();
        int index = getNameIndexInArrayList(classroom, studentName);

        if (index == -1) {
            System.out.println("Error: Name not found!");
            return;
        }

        classroom.remove(index);
    }
}
