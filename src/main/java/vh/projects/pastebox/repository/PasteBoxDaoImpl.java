package vh.projects.pastebox.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import vh.projects.pastebox.model.PasteBox;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PasteBoxDaoImpl implements PasteBoxDao {

    @Value("${server.port}")
    String serverPort;

    @Value("${host}")
    String host;

    @Value("${paste_list_size}")
    int listSize;

    final PasteBoxMongoRepo mongoRepo;

    public PasteBoxDaoImpl(PasteBoxMongoRepo mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public List<PasteBox> getLastPublicPastes() {
        //нужно переделать на запрос в монгоДБ
        List<PasteBox> list = mongoRepo.findAllByDecayDateAfterAndAccessStatus(LocalDateTime.now(), PasteBox.AccessStatus.PUBLIC);
        Collections.reverse(list);
        return list.stream().limit(listSize).collect(Collectors.toList());
    }

    @Override
    public Optional<PasteBox> getPasteByHash(String hash) {
        return mongoRepo.findById(hash);
    }

    @Override
    public String savePaste(PasteBox pasteBox) {
        pasteBox = mongoRepo.save(pasteBox);
        pasteBox.setHash(pasteBox.getId());
        return String.format("http://%s:%s/pastes/%s",host,serverPort,pasteBox.getHash());
    }
}
