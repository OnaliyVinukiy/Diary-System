import java.util.*;

public class XMLRepository implements DiaryRepository {

    private final String filePath;
    private final Map<String, Appointment> store = new LinkedHashMap<>();

    XMLRepository(String filePath) {
        this.filePath = filePath;
        System.out.println("[XMLRepository] Initialised: " + filePath);
    }

    private String key(Date date, String timeSlot) {
        return date.toString() + "_" + timeSlot;
    }

    @Override
    public boolean save(Appointment appt) {
        String k = key(appt.getDate(), appt.getTimeSlot());
        if (store.containsKey(k)) return false;
        store.put(k, appt);
        System.out.println("[XMLRepository] Saved: " + appt);
        return true;
    }

    @Override
    public boolean delete(Date date, String timeSlot) {
        boolean removed = store.remove(key(date, timeSlot)) != null;
        if (removed) System.out.println("[XMLRepository] Deleted: " + date + " " + timeSlot);
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