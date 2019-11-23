package two.x.two.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import two.x.two.dto.WordTo;

import java.util.UUID;

@Repository
public interface NamesRepository extends MongoRepository<WordTo, UUID> {
}
