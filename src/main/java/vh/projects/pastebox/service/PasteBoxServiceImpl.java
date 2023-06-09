package vh.projects.pastebox.service;

import org.springframework.stereotype.Service;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponsePasteBoxDto;
import vh.projects.pastebox.repository.PasteBoxDao;
import vh.projects.pastebox.repository.PasteBoxMongoRepo;
import vh.projects.pastebox.util.DtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PasteBoxServiceImpl implements PasteBoxService{

   final PasteBoxDao pasteBoxDao;

    public PasteBoxServiceImpl(PasteBoxDao pasteBoxDao, PasteBoxMongoRepo mongoRepo) {
        this.pasteBoxDao = pasteBoxDao;
    }

    @Override
    public List<ResponsePasteBoxDto> getLastPublicPastes() {
        return pasteBoxDao
                .getLastPublicPastes().stream()
                .map(DtoMapper::pasteBoxToDto).
                collect(Collectors.toList());
    }

    @Override
    public Optional<ResponsePasteBoxDto> getPasteByHash(String hash) {
       return pasteBoxDao.getPasteByHash(hash).map(DtoMapper::pasteBoxToDto);
    }

    @Override
    public String savePaste(RequestPasteBoxDto dto) {
        return pasteBoxDao.savePaste(DtoMapper.DtoToPasteBox(dto));
    }
}
