package CSVReader;

import CSVReader.event.Event;

import java.time.LocalDateTime;

public class CsvFileUtils {
    public static Event eventFromCsvLine(String csvRow){
        String[] stringArr = csvRow.split(",");
        Event event = new Event(Long.parseLong(stringArr[0]), stringArr[1], stringArr[2],LocalDateTime.parse(stringArr[3]), LocalDateTime.parse(stringArr[4]));
        return event;
    }

    public static String csvLineFromEvent(Event event){
        return String.format("%s%s,%s,%s,%s,%s", "\n",event.getId(), event.getName(), event.getDescription(), event.getStart(), event.getEnd());
    }
}
