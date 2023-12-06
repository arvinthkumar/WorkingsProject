import CSVReader.CsvFileDao;
import CSVReader.event.Event;

import java.time.LocalDateTime;

public class Main {
    public static void main(String args[]) {
        try {
            System.out.println(new CsvFileDao().read(Long.parseLong("3")));
//            System.out.println(new CsvFileDao().readAll());
//            new CsvFileDao().write(new Event(Long.parseLong("4"), "Qualtrics", "Conf on data analystics", LocalDateTime.parse("2020-02-20T19:00"), LocalDateTime.parse("2020-02-20T20:00")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}