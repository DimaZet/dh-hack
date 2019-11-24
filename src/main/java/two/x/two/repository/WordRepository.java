package two.x.two.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import two.x.two.repository.entry.Word;

@Repository
public interface WordRepository extends MongoRepository<Word, UUID> {
}
