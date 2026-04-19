import java.util.Date;
import java.util.List;
 
// Product interface
public interface DiaryRepository {
    boolean save(Appointment appointment);
    boolean delete(Date date, String timeSlot);
    Appointment find(Date date, String timeSlot);
    List<Appointment> findAll();
}