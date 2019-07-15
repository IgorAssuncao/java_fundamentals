import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileClass {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar calendar = Calendar.getInstance();

    private String fileName;

    public FileClass(String fileName) {
        this.fileName = fileName;
    }

    public Scanner openFileToRead() {
        Scanner input = null;
        try {
            input = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File not found to be read.");
            System.out.println(fileNotFoundException.getMessage());
        }
        return input;
    }

    public void readClientsFile(Scanner input, ArrayList<Client> clientArrayList) {
        String[] fields;

        try {
            while (input.hasNext()) {
                fields = input.nextLine().split(";");
                clientArrayList.add(new Client(
                        fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Double.parseDouble(fields[3])
                ));
            }
        } catch (Exception exception) {
            System.out.println("Error reading clients file.");
            System.out.println(exception.getMessage());
        }
    }

    public void readCallsFile(Scanner input, ArrayList<Call> callArrayList) {
        String[] fields;
        try {
            while (input.hasNext()) {
                fields = input.nextLine().split(";");
                calendar.setTime(simpleDateFormat.parse(fields[2]));
                Date startDate = calendar.getTime();
                calendar.setTime(simpleDateFormat.parse(fields[3]));
                Date endDate = calendar.getTime();

                callArrayList.add(new Call(
                        fields[0],
                        fields[1],
                        startDate,
                        endDate
                ));
            }
        } catch (Exception exception) {
            System.out.println("Error reading calls file.");
            System.out.println(exception.getMessage());
        }
    }

    public Formatter openFileToSave() {
        Formatter output = null;
        try {
            output = new Formatter(new File(this.fileName));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File not found to be saved.");
            System.out.println(fileNotFoundException.getMessage());
        }
        return output;
    }

    public void saveClientsFile(Formatter output, ArrayList<Client> clientsArrayList) {
        for (Client client: clientsArrayList) {
            output.format("%s;%s;%d;%f\n",
                    client.getNumber(),
                    client.getName(),
                    client.getPlanType(),
                    client.getCredits()
            );
        }
    }

    public void saveCallsFile(Formatter output, ArrayList<Call> callsArrayList) {
        for (Call call: callsArrayList) {
            output.format("%s;%s;%s;%s\n",
                    call.getSourceNumber(),
                    call.getDestinationNumber(),
                    simpleDateFormat.format(call.getStartDate()),
                    simpleDateFormat.format(call.getEndDate())
            );
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

}
