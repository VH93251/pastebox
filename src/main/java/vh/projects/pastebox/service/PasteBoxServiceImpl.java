package vh.projects.pastebox.service;

import org.springframework.stereotype.Service;
import vh.projects.pastebox.model.dto.RequestPasteBoxDto;
import vh.projects.pastebox.model.dto.ResponcePasteBoxDto;
import vh.projects.pastebox.repository.PasteBoxDao;
import vh.projects.pastebox.util.DtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PasteBoxServiceImpl implements PasteBoxService{

    PasteBoxDao pasteBoxDao;

    public PasteBoxServiceImpl(PasteBoxDao pasteBoxDao) {
        this.pasteBoxDao = pasteBoxDao;
    }

    @Override
    public List<ResponcePasteBoxDto> getLastPublicPastes() {
        return pasteBoxDao.getLastPublicPastes().stream().map(DtoMapper::pasteBoxToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ResponcePasteBoxDto> getPasteByHash(long hash) {
       return pasteBoxDao.getPasteByHash(hash).map(DtoMapper::pasteBoxToDto);
    }

    @Override
    public String savePaste(RequestPasteBoxDto dto) {
        return pasteBoxDao.savePaste(DtoMapper.DtoToPasteBox(dto));
    }
}
