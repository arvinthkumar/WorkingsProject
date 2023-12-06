package CSVReader;

import CSVReader.event.Event;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CsvFileDao {

    public static List<Event> readAll() throws Exception{
        ArrayList eventList = new ArrayList<Event>();
        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
        String filePath = PropertiesFileHelper.csvFilePathFromProperties();
        Path path = Paths.get(filePath+csvFileName);
        List<String> contents = Files.readAllLines(path);
        for(String line : contents){
            eventList.add(CsvFileUtils.eventFromCsvLine(line));
        }
        return eventList;
    }
    public Event read(Long eventId) throws Exception{
        for(Event event : CsvFileDao.readAll()){
            if(event.getId().equals(eventId))
                return event;
        }
        return null;
    }

    public void write(Event event) throws Exception{
        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
        String filePath = PropertiesFileHelper.csvFilePathFromProperties();
        Path path = Paths.get(filePath+csvFileName);
        Files.write(path, CsvFileUtils.csvLineFromEvent(event).getBytes(), StandardOpenOption.APPEND);
    }

//    public List<Event> readAll() throws Exception{
//        ArrayList eventList = new ArrayList<Event>();
//        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
//        String line = "";
//
//        BufferedReader br = new BufferedReader(new FileReader(csvFileName));
//        while ((line = br.readLine()) != null){
//            eventList.add(CsvFileUtils.eventFromCsvLine(line));
//        }
//
//        return eventList;
//    }

}
