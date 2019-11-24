package two.x.two.config;

import java.io.IOException;

import org.apache.lucene.morphology.russian.RussianLuceneMorphology;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import two.x.two.client.WordFromTextClient;

@Configuration
public class ContextConfig {

    @Bean
    RussianLuceneMorphology russianLuceneMorphology() throws IOException {
        return new RussianLuceneMorphology();
    }

    @Bean
    WordFromTextClient wordService() {
        WordFromTextClient wordFromTextClient = new WordFromTextClient();
        wordFromTextClient.getHeaders().setContentType(MediaType.MULTIPART_FORM_DATA);
        wordFromTextClient.getMap().add("text", "text");
        return wordFromTextClient;
    }
}
