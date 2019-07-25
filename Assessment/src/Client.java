public class Client {
    private String number;
    private String name;
    private int planType; // 1 - Pre paid, 2 - Post paid.
    private double initialCredits;
    private double credits;
    private double minutesSpent;

    public Client(String number, String name, int planType, double credits) {
        this.number = number;
        this.name = name;
        if (validPlanType(planType)) {
            this.planType = planType;
        }
        this.initialCredits = credits;
        this.credits = credits;
        this.minutesSpent = 0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }

    public double getInitialCredits() {
        return initialCredits;
    }

    public void setInitialCredits(double initialCredits) {
        this.initialCredits = initialCredits;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getMinutesSpent() {
        return minutesSpent;
    }

    public void setMinutesSpent(double minutesSpent) {
        this.minutesSpent = minutesSpent;
    }

    public static boolean validPlanType(int planType) {
        return planType == 1 || planType == 2;
    }

    @Override
    public String toString() {
        String clientString = "Client number: " + this.getNumber() +
                "\nClient name: " + this.getName() +
                "\nClient plan type: " + this.getPlanType();

        if (this.getPlanType() == 1) clientString += " - Pre paid";
        if (this.getPlanType() == 2) clientString += " - Post paid";
        clientString += "\nInitial credits: $" + this.getInitialCredits();
        clientString += "\nClient credits: $" + this.getCredits();
        clientString += "\nMinutes spent: " + this.getMinutesSpent() + "\n";

        return clientString;
    }
}