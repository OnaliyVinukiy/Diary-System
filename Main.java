import java.util.Date;

public class Main {

    public static void main(String[] args) {

        DiaryRepositoryFactory factory = new CSVRepositoryFactory("diary.csv");
        DiaryRepositoryFactory factory = new XMLRepositoryFactory("diary.xml");
        DiaryRepositoryFactory factory = new DatabaseRepositoryFactory("jdbc:mysql://localhost/clinic");

        // Inject factory into Singleton Diary
        Diary diary = Diary.getInstance();
        diary.setFactory(factory);
        

        // Use the diary
        Date today = new Date();

        Appointment a1 = new Appointment(today, "09:00", "Alice Smith",  "Check-up");
        Appointment a2 = new Appointment(today, "10:00", "Bob Jones",    "Blood test");
        Appointment a3 = new Appointment(today, "09:00", "Carol White",  "Duplicate slot");

        System.out.println("\n── Adding appointments ──");
        System.out.println("Add a1: " + diary.addAppointment(a1));
        System.out.println("Add a2: " + diary.addAppointment(a2));
        System.out.println("Add a3: " + diary.addAppointment(a3));

        System.out.println("\n── All appointments ─────");
        diary.listAppointments().forEach(System.out::println);

        System.out.println("\n── Delete 10:00 ─────────");
        System.out.println(diary.deleteAppointment(today, "10:00"));
        System.out.println(diary.deleteAppointment(today, "10:00"));

        System.out.println("\n── Switch to XML backend ─");
        diary.setFactory(new XMLRepositoryFactory("diary.xml"));
        diary.addAppointment(new Appointment(today, "11:00", "Dan Brown", "Follow-up"));
        diary.listAppointments().forEach(System.out::println);
    }
}