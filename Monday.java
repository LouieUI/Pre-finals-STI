import java.util.Scanner;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Monday extends Weekday {
    public static void main(String[] args) {
        Scanner day = new Scanner(System.in);
        System.out.print("Set time for alarm in this format (Hr:Mn): ");
        String time = day.nextLine();

        Monday monday = new Monday();
        monday.setAlarm(time);
        monday.showAlarm();

        day.close();
    }

    @Override
    public void setAlarm(String time) {
        this.time = time; 
    }

    @Override
    public void showAlarm() {
        LocalTime alarm;
        try {
            alarm = LocalTime.parse(time);
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Manila"));
 
            if (alarm.isAfter(now.toLocalTime())) {
                System.out.println("I'll wake you up");
            } else {
                System.out.println("Alarm is set for tomorrow!");
            }
        } catch (Exception e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
        }
    }
}

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}



abstract class Weekday implements Alarm {
    protected String time; 
}