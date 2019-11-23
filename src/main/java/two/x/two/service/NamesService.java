package two.x.two.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import two.x.two.dto.NerResponceTo;
import two.x.two.dto.WordTo;

import java.net.URI;
import java.util.List;

@Service
public class NamesService {

    public static final int MAX_TEXT_SIZE = 1000;

    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://ner-ru.apphb.com/RESTProcessHandler.ashx");
    HttpHeaders headers = new HttpHeaders();
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

    public NamesService() {
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        map.add("text", "text");
    }

    public List<WordTo> getWords(String text) {
        if (text.length() > MAX_TEXT_SIZE) {
            text = text.substring(0, MAX_TEXT_SIZE);
        }
        map.add("text", text);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return restTemplate.postForEntity(uri, request, NerResponceTo.class)
                .getBody().getWords();
    }
}
