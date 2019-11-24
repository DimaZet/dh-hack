package two.x.two.client;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import two.x.two.client.dto.NerResponceTo;
import two.x.two.client.dto.WordTo;

public class WordFromTextClient {

    public static final int MAX_TEXT_SIZE = 1000;

    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://ner-ru.apphb.com/RESTProcessHandler.ashx");
    HttpHeaders headers = new HttpHeaders();
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public MultiValueMap<String, String> getMap() {
        return map;
    }

    public void setMap(MultiValueMap<String, String> map) {
        this.map = map;
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
