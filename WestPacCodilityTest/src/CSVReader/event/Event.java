package CSVReader.event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
}
