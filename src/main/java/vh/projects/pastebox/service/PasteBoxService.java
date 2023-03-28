package vh.projects.pastebox.service;

import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponsePasteBoxDto;

import java.util.List;
import java.util.Optional;

public interface PasteBoxService {
    List<ResponsePasteBoxDto> getLastPublicPastes();
    Optional<ResponsePasteBoxDto> getPasteByHash(String hash);
    String savePaste(RequestPasteBoxDto dto);
}
