package vh.projects.pastebox.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import vh.projects.pastebox.model.PasteBox;

import java.time.LocalDateTime;
import java.util.List;

@EnableMongoRepositories

public interface PasteBoxMongoRepo extends MongoRepository<PasteBox,String> {
    List<PasteBox> findAllByDecayDateAfterAndAccessStatus(LocalDateTime decayDate, PasteBox.AccessStatus accessStatus);

}

