import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int END = 0;
        final String CLIENTS_FILE_NAME = "clients.txt";
        final String CALLS_FILE_NAME = "calls.txt";

        ArrayList<Client> clientsArrayList = new ArrayList<>();
        ArrayList<Call> callsArrayList = new ArrayList<>();

        FileClass clientsFile = new FileClass(CLIENTS_FILE_NAME);
        FileClass callsFile = new FileClass(CALLS_FILE_NAME);

        Scanner inputClientsFile = clientsFile.openFileToRead();
        if (inputClientsFile != null) {
            clientsFile.readClientsFile(inputClientsFile, clientsArrayList);
            clientsFile.closeFile(inputClientsFile);
        }

        Scanner inputCallsFile = callsFile.openFileToRead();
        if (inputCallsFile != null) {
            callsFile.readCallsFile(inputCallsFile, callsArrayList);
            callsFile.closeFile(inputCallsFile);
        }

        int optionFromMainMenu = Menu.getOptionFromMainMenu();
        while (optionFromMainMenu != END) {
            switch (optionFromMainMenu) {
                case 1:
                    addClient(clientsArrayList);
                    break;
                case 2:
                    updateClient(clientsArrayList);
                    break;
                case 3:
                    removeClient(clientsArrayList);
                    break;
                case 4:
                    addCall(callsArrayList, clientsArrayList);
                    break;
                case 5:
                    reports(clientsArrayList, callsArrayList);
                    break;
                default:
                    break;
            }
            optionFromMainMenu = Menu.getOptionFromMainMenu();
        }

        Formatter outputClientsFile = clientsFile.openFileToSave();
        if (outputClientsFile != null) {
            clientsFile.saveClientsFile(outputClientsFile, clientsArrayList);
            clientsFile.closeFile(outputClientsFile);
        }

        Formatter outputCallsFile = callsFile.openFileToSave();
        if (outputCallsFile != null) {
            callsFile.saveCallsFile(outputCallsFile, callsArrayList);
            callsFile.closeFile(outputCallsFile);
        }
    }

    public static boolean clientExists(ArrayList<Client> clientsArrayList, String clientNumber) {
        for (Client clientInLoop : clientsArrayList) {
            if (clientNumber.equals(clientInLoop.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public static int getClientNumberIndex(ArrayList<Client> clientsArrayList, String clientNumber) {
        int index = -1;
        for (int i = 0; i < clientsArrayList.size(); i++) {
            if (clientNumber.equals(clientsArrayList.get(i).getNumber())) {
                index = i;
            }
        }
        return index;
    }

    public static int getClientPlanTypeFromMenu() {
        int planType;
        do {
            planType = Menu.getIntegerInput("Enter the plan type (1- Pre paid, 2- Post paid): ");
            if (planType != 1 && planType != 2) System.out.println("Plan type must be 1 or 2.");
        } while (planType != 1 && planType != 2);
        return planType;
    }

    public static void addClient(ArrayList<Client> clientsArrayList) {
        if (clientsArrayList == null) {
            System.out.println("Error: Clients list is null.\n");
            return;
        }
        String clientNumber = Menu.getCellphoneNumber("Client cellphone number: ");
        if (clientExists(clientsArrayList, clientNumber)) {
            System.out.println("Error: Client number already exists.\n");
            return;
        }
        String clientName = Menu.getStringInput("Client name: ");
        int clientPlanType = getClientPlanTypeFromMenu();

        double clientCredits = 0;
        if (clientPlanType == 1) clientCredits = Menu.getDoubleInput("Client credits: ");

        Client client = new Client(
                clientNumber,
                clientName,
                clientPlanType,
                clientCredits
        );
        clientsArrayList.add(client);
        System.out.println("Success: client added.\n");
    }

    private static void updateClientName(Client client) {
        String name = Menu.getStringInput("Enter the new name: ");
        client.setName(name);
    }

    private static void updateClientPlanType(Client client) {
        int newPlanType;
        do {
            newPlanType = Menu.getIntegerInput("Enter the new plan type (1- Pre paid, 2- Post paid): ");
        } while (!Client.validPlanType(newPlanType));
        client.setPlanType(newPlanType);
    }

    public static void updateClientCredits(Client client, double credits) {
        if (client.getPlanType() == 1) {
            if (client.getCredits() > credits) {
                client.setCredits(client.getCredits() - credits);
            } else {
                client.setCredits(0);
            }
        }
        if (client.getPlanType() == 2) client.setCredits(client.getCredits() + credits);
    }

    private static void updateClientCredits(Client client) {
        double credits = Menu.getCreditsInput("Enter new credits amount: ");
        client.setCredits(credits);
    }

    public static void updateClient(ArrayList<Client> clientsArrayList) {
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        String clientNumber = Menu.getCellphoneNumber("Client cellphone number: ");
        Client client;
        int optionToUpdate;
        if (!(clientExists(clientsArrayList, clientNumber))) {
            System.out.println("Error: Client does not exists.\n");
            return;
        }
        client = clientsArrayList.get(getClientNumberIndex(clientsArrayList, clientNumber));
        do {
            optionToUpdate = Menu.getOptionToUpdateClient();
            switch (optionToUpdate) {
                case 1:
                    updateClientName(client);
                    break;
                case 2:
                    updateClientPlanType(client);
                    break;
                case 3:
                    updateClientCredits(client);
                    break;
                default:
                    break;
            }
        } while (optionToUpdate != 0);

    }

    public static void removeClient(ArrayList<Client> clientsArrayList) {
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        String clientNumber = Menu.getCellphoneNumber("Client cellphone number: ");
        if (!(clientExists(clientsArrayList, clientNumber))) {
            System.out.println("Error: Client does not exists.\n");
            return;
        }

        clientsArrayList.remove(getClientNumberIndex(clientsArrayList, clientNumber));
        System.out.println("Success: client removed.\n");
    }

    public static void addCall(ArrayList<Call> callsArrayList, ArrayList<Client> clientsArrayList) {
        if (callsArrayList == null) {
            System.out.println("Error: Calls list is null.\n");
            return;
        }
        if (clientsArrayList == null) {
            System.out.println("Error: Clients list is null.\n");
            return;
        }
        String source = Menu.getCellphoneNumber("Call source cellphone number: ");
        if (!clientExists(clientsArrayList, source)) {
            System.out.println("Source cellphone number does not exist.\n");
            return;
        }
        String destination = Menu.getCellphoneNumber("Call destination cellphone number: ");
        if (!clientExists(clientsArrayList, destination)) {
            System.out.println("Destination cellphone number does not exist.\n");
            return;
        }
        Date startDate = Menu.getDateInput("Start date: ");
        Date endDate;
        do {
             endDate = Menu.getDateInput("End date: ");
        } while (endDate.before(startDate));

        Call call = new Call(
                source,
                destination,
                startDate,
                endDate
        );
        callsArrayList.add(call);

    }

    public static void printClient(Client client) {
        System.out.println(client);
    }

    public static void printCalls(Call call) {
        System.out.println(call);
    }

    public static void listClientCalls(Client client, ArrayList<Call> callsArrayList) {
        System.out.println("\n-----Calls-----\n");
        if (callsArrayList == null || callsArrayList.size() <= 0) {
            System.out.println("Error: Calls list is empty.\n");
            return;
        }
        for (Call call : callsArrayList) {
            if (client.getNumber().equals(call.getSourceNumber())) {
                printCalls(call);
            }
        }
        System.out.println();
    }

    public static void listAllClients(ArrayList<Client> clientsArrayList) {
        System.out.println("\n-----Clients-----\n");
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        for (Client client : clientsArrayList) {
            printClient(client);
        }
        System.out.println();
    }

    public static void listClientWithZeroOrNegativeCredit(ArrayList<Client> clientsArrayList) {
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        ArrayList<Client> clientsZeroNegativeCredit = new ArrayList<>();
        for (Client client: clientsArrayList) {
            if (client.getCredits() <= 0) {
                clientsZeroNegativeCredit.add(client);
            }
        }
        if (clientsZeroNegativeCredit.size() <= 0) {
            System.out.println("No clients with zero or less credits.\n");
            return;
        }
        for (Client client: clientsZeroNegativeCredit) {
            printClient(client);
        }
        System.out.println();
    }

    public static void listClientsWithCreditGreaterThanAmount(ArrayList<Client> clientsArrayList, ArrayList<Call> callsArrayList, double creditsAmount) {
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        if (callsArrayList == null || callsArrayList.size() <= 0) {
            System.out.println("Error: Calls list is empty.\n");
            return;
        }
        for (Client client: clientsArrayList) {
            if (client.getCredits() >= creditsAmount) {
                printClient(client);
            }
        }
        System.out.println();
    }

    public static void listClientWithGreatestCredits(ArrayList<Client> clientsArrayList) {
        double biggestCredits = Double.MIN_VALUE;
        if (clientsArrayList == null || clientsArrayList.size() <= 0) {
            System.out.println("Error: Clients list is empty.\n");
            return;
        }
        int index = -1;
        for (int i = 0; i < clientsArrayList.size(); i++) {
            if (clientsArrayList.get(i).getCredits() > biggestCredits) {
                index = i;
                biggestCredits = clientsArrayList.get(i).getCredits();
            }
        }

        Client client = clientsArrayList.get(index);
        printClient(client);
    }

    public static double getClientBill(Client client, ArrayList<Call> callsArrayList) {
        double bill = 0;
        double callDuration;
        for (Call call: callsArrayList) {
            if (client.getNumber().equals(call.getSourceNumber())) {
                callDuration = call.getDuration();
                if (callDuration <= 1.0) bill += 1;
                else bill += callDuration;
            }
        }
        return bill;
    }

    public static void generateClientBill(Client client, ArrayList<Call> callsArrayList) {
        if (callsArrayList.size() <= 0) {
            System.out.println("Error: Calls list is empty.\n");
            return;
        }
        double bill = getClientBill(client, callsArrayList);
        double duration = 0;
        for (Call call: callsArrayList) {
            if(client.getNumber().equals(call.getSourceNumber())) {
                duration += call.getCallDuration();
            }
        }
        updateClientCredits(client, duration);
        client.setMinutesSpent(duration);
        printClient(client);
        listClientCalls(client, callsArrayList);
        System.out.println("Bill: $" + bill + "\n");
    }

    public static void reports(ArrayList<Client> clientsArrayList, ArrayList<Call> callsArrayList) {
        final int END = 0;
        String clientNumber;
        Client client;
        int optionFromReportMenu = Menu.getOptionFromReportsMenu();

        while (optionFromReportMenu != END) {
            switch (optionFromReportMenu) {
                case 1:
                    listAllClients(clientsArrayList);
                    break;
                case 2:
                    listClientWithZeroOrNegativeCredit(clientsArrayList);
                    break;
                case 3:
                    double credits = Menu.getCreditsInput("Amount: ");
                    listClientsWithCreditGreaterThanAmount(clientsArrayList, callsArrayList, credits);
                    break;
                case 4:
                    listClientWithGreatestCredits(clientsArrayList);
                    break;
                case 5:
                    do {
                        clientNumber = Menu.getCellphoneNumber("Client cellphone Number: ");
                        if (!(clientExists(clientsArrayList, clientNumber))) System.out.println("Error: Client does not exists.\nTry again.\n");
                    } while (!(clientExists(clientsArrayList, clientNumber)));
                    client = clientsArrayList.get((getClientNumberIndex(clientsArrayList, clientNumber)));
                    generateClientBill(client, callsArrayList);
                    break;
                default:
                    break;
            }
            optionFromReportMenu = Menu.getOptionFromReportsMenu();
        }
    }
}
