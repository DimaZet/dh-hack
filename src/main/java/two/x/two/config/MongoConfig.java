package two.x.two.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("two.x.two.config.repository")
public class MongoConfig {

}
