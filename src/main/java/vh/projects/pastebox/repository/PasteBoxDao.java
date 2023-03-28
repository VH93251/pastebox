package vh.projects.pastebox.repository;

import vh.projects.pastebox.model.PasteBox;

import java.util.List;
import java.util.Optional;

public interface PasteBoxDao {

    List<PasteBox> getLastPublicPastes();
    Optional<PasteBox> getPasteByHash(long hash);
    String savePaste(PasteBox pasteBox);
}
