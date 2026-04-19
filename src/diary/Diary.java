import java.util.Date;
import java.util.List;

public class Diary {

    // Singleton
    private static Diary instance;

    private Diary() { }

    public static Diary getInstance() {
        if (instance == null) {
            instance = new Diary();
        }
        return instance;
    }

    // Factory method integration
    private DiaryRepositoryFactory factory;
    private DiaryRepository        repository;

    public void setFactory(DiaryRepositoryFactory factory) {
        this.factory    = factory;
        this.repository = factory.createRepository();
    }

    // Appointment operations
    public boolean addAppointment(Appointment appt) {
        ensureReady();
        return repository.save(appt);
    }

    public boolean deleteAppointment(Date date, String timeSlot) {
        ensureReady();
        return repository.delete(date, timeSlot);
    }

    public Appointment getAppointment(Date date, String timeSlot) {
        ensureReady();
        return repository.find(date, timeSlot);
    }

    public List<Appointment> listAppointments() {
        ensureReady();
        return repository.findAll();
    }

    private void ensureReady() {
        if (repository == null)
            throw new IllegalStateException("Call setFactory() before using Diary.");
    }
}