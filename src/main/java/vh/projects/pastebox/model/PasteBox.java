package vh.projects.pastebox.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PasteBox {
    @Id
    private String id;
    private String paste;
    private AccessStatus accessStatus;
    private LocalDateTime decayDate;
    private String hash;
    @CreatedDate
    private Instant timeStamp;



    public enum AccessStatus{
        PUBLIC,
        UNLISTED
    }
}
