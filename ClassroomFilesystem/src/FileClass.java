import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FileClass {
    private String fileName;

    public FileClass(String fileName) {
        this.fileName = fileName;
    }

    public Scanner openFile() {
        Scanner input = null;

        try {
            input = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File couldn't be opened.");
            System.out.println(fileNotFoundException.getMessage());
        }

        return input;
    }

    public void readFile(Scanner input, ArrayList<Student> classroom) {
        String line;
        String[] fields;

        try {
            while (input.hasNext()) {
                line = input.nextLine();
                fields = line.split(";");

                Student student = new Student(
                        fields[0],
                        Integer.parseInt(fields[1]),
                        Integer.parseInt(fields[2])
                );

                classroom.add(student);
            }
        } catch (Exception exception) {
            System.out.println("Error reading file.");
        }
    }

    public void closeFile(Scanner input) {
        if (input != null) {
            System.out.println("Closing file.");
            input.close();
        }
    }

    public void closeFile(Formatter output) {
        if (output != null) {
            System.out.println("Closing file.");
            output.close();
        }
    }

    public Formatter openFileToSave() {
        Formatter output = null;

        try {
            output = new Formatter(new File(this.fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error opening file to save.");
        }

        return output;
    }

    public void saveFile(Formatter output, ArrayList<Student> classroom) {
        for (Student student : classroom) {
            try {
                output.format(
                        "%s;%d;%d\n",
                        student.getName(),
                        student.getGrade1(),
                        student.getGrade2()
                );
            } catch (Exception exception) {
                System.out.println("Error saving file.");
            }
        }
    }
}
