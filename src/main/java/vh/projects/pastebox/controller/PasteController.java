package vh.projects.pastebox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.service.PasteBoxService;

@RestController
@RequestMapping("/pastes")
public class PasteController {

    PasteBoxService pasteBoxService;

    public PasteController(PasteBoxService pasteBoxService) {
        this.pasteBoxService = pasteBoxService;
    }

    @PostMapping
    public String savePaste(@RequestBody RequestPasteBoxDto dto) {
        return pasteBoxService.savePaste(dto);
    }
}