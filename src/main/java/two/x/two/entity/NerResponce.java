package two.x.two.entity;

import java.util.List;

public class NerResponce {
    List<Word> words;

    public NerResponce() {
    }

    public NerResponce(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
