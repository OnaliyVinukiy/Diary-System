import java.util.Date;

public class Appointment {

    private Date date;
    private String timeSlot;
    private String patientName;
    private String description;

    public Appointment(Date date, String timeSlot, String patientName, String description) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.patientName = patientName;
        this.description = description;
    }

    public Date getDate() { return date; }
    public String getTimeSlot() { return timeSlot; }
    public String getPatientName() { return patientName; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "[" + date + " " + timeSlot + "] "
             + patientName + " - " + description;
    }
}