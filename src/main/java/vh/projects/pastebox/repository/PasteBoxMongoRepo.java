package vh.projects.pastebox.repository;

import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import vh.projects.pastebox.model.PasteBox;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories

public interface PasteBoxMongoRepo extends MongoRepository<PasteBox,String> {
    List<PasteBox> findFirst10ByOrderByTimeStampDesc();
}
