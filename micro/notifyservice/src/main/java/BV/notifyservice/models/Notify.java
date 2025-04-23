package BV.notifyservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notifications")
public class Notify {
    @Id
    private String id;
    private Long userId;
    private String type;
    private String message;
    private LocalDateTime timestamp;
}
