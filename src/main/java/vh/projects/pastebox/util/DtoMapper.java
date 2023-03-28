package vh.projects.pastebox.util;

import vh.projects.pastebox.model.PasteBox;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponcePasteBoxDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DtoMapper {

    public static PasteBox DtoToPasteBox(RequestPasteBoxDto dto) {

        return  PasteBox.builder()
                .paste(dto.paste())
                .accessStatus(dto.accessStatus())
                .decayDate(LocalDateTime.now().plus(dto.liveTime(), ChronoUnit.MINUTES))
                .build();
    }

    public static ResponcePasteBoxDto pasteBoxToDto(PasteBox pasteBox) {
        return new ResponcePasteBoxDto(pasteBox.getPaste());
    }

}
