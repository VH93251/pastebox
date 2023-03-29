package vh.projects.pastebox.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vh.projects.pastebox.model.PasteBox;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponsePasteBoxDto;
import vh.projects.pastebox.repository.PasteBoxMongoRepo;
import vh.projects.pastebox.service.PasteBoxService;

import java.util.Collection;

@RestController
@RequestMapping("/pastes")
public class PasteController {

    PasteBoxService pasteBoxService;


    public PasteController(PasteBoxService pasteBoxService, PasteBoxMongoRepo mb) {
        this.pasteBoxService = pasteBoxService;
    }

    @PostMapping
    public String savePaste(@RequestBody RequestPasteBoxDto dto) {
        return pasteBoxService.savePaste(dto);
    }

    @GetMapping
    public ResponseEntity<Collection<ResponsePasteBoxDto>> getLastPublicPastes() {
        return new ResponseEntity<>(pasteBoxService.getLastPublicPastes(), HttpStatus.OK);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<ResponsePasteBoxDto> getPaste(@PathVariable(name = "hash") String hash) {
        ResponsePasteBoxDto response = pasteBoxService.getPasteByHash(hash).orElse(null);
        return response!=null?
                new ResponseEntity<>(response, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}