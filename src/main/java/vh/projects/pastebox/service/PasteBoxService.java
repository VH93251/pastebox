package vh.projects.pastebox.service;

import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponcePasteBoxDto;

import java.util.List;
import java.util.Optional;

public interface PasteBoxService {
    List<ResponcePasteBoxDto> getLastPublicPastes();
    Optional<ResponcePasteBoxDto> getPasteByHash(long hash);
    String savePaste(RequestPasteBoxDto dto);
}
