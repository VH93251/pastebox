package vh.projects.pastebox.model;


import lombok.*;
import vh.projects.pastebox.util.HashGenerator;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasteBox {
    String paste;
    AccessStatus accessStatus;
    LocalDateTime decayDate;
    final String hash = String.valueOf(HashGenerator.getHash());


    public enum AccessStatus{
        PUBLIC,
        UNLISTED
    }
}
