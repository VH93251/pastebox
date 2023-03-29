package vh.projects.pastebox.util;

import vh.projects.pastebox.model.PasteBox;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponsePasteBoxDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DtoMapper {

    public static PasteBox DtoToPasteBox(RequestPasteBoxDto dto) {

        PasteBox pasteBox = new PasteBox();
        pasteBox.setPaste(dto.paste());
        pasteBox.setAccessStatus(dto.accessStatus());
        pasteBox.setDecayDate(LocalDateTime.now().plus(dto.liveTime(), ChronoUnit.MINUTES));
        return pasteBox;
    }

    public static ResponsePasteBoxDto pasteBoxToDto(PasteBox pasteBox) {
        return new ResponsePasteBoxDto(pasteBox.getPaste());
    }

}
