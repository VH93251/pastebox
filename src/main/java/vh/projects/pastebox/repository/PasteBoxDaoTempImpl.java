package vh.projects.pastebox.repository;

import org.springframework.stereotype.Repository;
import vh.projects.pastebox.model.PasteBox;

import java.util.List;
import java.util.Optional;

@Repository
public class PasteBoxDaoTempImpl implements PasteBoxDao {

    final PasteBoxMongoRepo mongoRepo;

    public PasteBoxDaoTempImpl(PasteBoxMongoRepo mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public List<PasteBox> getLastPublicPastes() {
        return mongoRepo.findFirst10ByOrderByTimeStampDesc();
    }

    @Override
    public Optional<PasteBox> getPasteByHash(String hash) {
        return mongoRepo.findById(hash);
    }

    @Override
    public String savePaste(PasteBox pasteBox) {
        pasteBox = mongoRepo.save(pasteBox);
        pasteBox.setHash(pasteBox.getId());
        return "http://localhost:8080/pastes/" + pasteBox.getHash();
    }
}
