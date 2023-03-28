package vh.projects.pastebox.util;

import vh.projects.pastebox.model.PasteBox;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponsePasteBoxDto;

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

    public static ResponsePasteBoxDto pasteBoxToDto(PasteBox pasteBox) {
        return new ResponsePasteBoxDto(pasteBox.getPaste());
    }

}
