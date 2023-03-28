package vh.projects.pastebox.repository;

import org.springframework.stereotype.Repository;
import vh.projects.pastebox.model.PasteBox;
import static vh.projects.pastebox.tempDB.TempDB.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PasteBoxDaoTempImpl implements PasteBoxDao {

    @Override
    public List<PasteBox> getLastPublicPastes() {
        List<PasteBox> temDB1 = new LinkedList<>(temDB);
         Collections.reverse(temDB1);
         return temDB1.stream().filter(pasteBox -> pasteBox.getDecayDate().isAfter(LocalDateTime.now())).limit(10).collect(Collectors.toList());
    }

    @Override
    public Optional<PasteBox> getPasteByHash(long hash) {
       return temDB.stream().filter(pasteBox -> pasteBox.getHash().equals(String.valueOf(hash))).findAny();

    }

    @Override
    public String savePaste(PasteBox pasteBox) {
        temDB.add(pasteBox);
        return "http://localhost:8080/pastes/"+pasteBox.getHash();
    }
}
