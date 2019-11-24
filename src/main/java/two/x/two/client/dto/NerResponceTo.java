package two.x.two.client.dto;

import java.util.List;

public class NerResponceTo {
    List<WordTo> words;

    public NerResponceTo() {
    }

    public NerResponceTo(List<WordTo> words) {
        this.words = words;
    }

    public List<WordTo> getWords() {
        return words;
    }

    public void setWords(List<WordTo> words) {
        this.words = words;
    }
}
