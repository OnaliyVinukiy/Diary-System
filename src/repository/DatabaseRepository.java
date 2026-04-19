import java.util.*;

public class DatabaseRepository implements DiaryRepository {

    private final String connectionURL;
    private final Map<String, Appointment> store = new LinkedHashMap<>();

    DatabaseRepository(String connectionURL) {
        this.connectionURL = connectionURL;
        System.out.println("[DatabaseRepository] Connected: " + connectionURL);
    }

    private String key(Date date, String timeSlot) {
        return date.toString() + "_" + timeSlot;
    }

    @Override
    public boolean save(Appointment appt) {
        String k = key(appt.getDate(), appt.getTimeSlot());
        if (store.containsKey(k)) return false;
        store.put(k, appt);
        System.out.println("[DatabaseRepository] Inserted: " + appt);
        return true;
    }

    @Override
    public boolean delete(Date date, String timeSlot) {
        boolean removed = store.remove(key(date, timeSlot)) != null;
        if (removed) System.out.println("[DatabaseRepository] Deleted: " + date + " " + timeSlot);
        return removed;
    }

    @Override
    public Appointment find(Date date, String timeSlot) {
        return store.get(key(date, timeSlot));
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(store.values());
    }
}