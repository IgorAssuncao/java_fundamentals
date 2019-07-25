import java.util.Date;

public class Call {
    private String sourceNumber;
    private String destinationNumber;
    private Date startDate;
    private Date endDate;
    private double duration;

    public Call(String sourceNumber, String destinationNumber, Date startDate, Date endDate) {
        this.sourceNumber = sourceNumber;
        this.destinationNumber = destinationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = this.getCallDuration();
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
    }

    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getCallDurationInSeconds() {
        return (int) (((this.endDate.getTime() - this.startDate.getTime()) / 1000) % 60);
    }

    public int getCallDurationInMinutes() {
        return (int) (this.endDate.getTime() - this.startDate.getTime()) / (1000 * 60);
    }

    public double getCallDuration(){
        double minutes = (double) this.getCallDurationInMinutes();
        double seconds = ((double) this.getCallDurationInSeconds()) / 60;
        return minutes + seconds;
    }

    @Override
    public String toString() {
        String callString = "Call source number: " + this.getSourceNumber() +
                "\nCall destination: " + this.getDestinationNumber() +
                "\nCall start date: " + this.getStartDate() +
                "\nCall end date: " + this.getEndDate() +
                "\nCall duration: " +
                this.getCallDurationInMinutes() + " minutes " +
                this.getCallDurationInSeconds() + " seconds\n";

        return callString;
    }
}