package two.x.two.client.transformer;

import org.apache.lucene.morphology.russian.RussianLuceneMorphology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import two.x.two.client.dto.WordTo;
import two.x.two.repository.entry.Word;

@Component
public class WordTransformer {

    private final RussianLuceneMorphology russianLuceneMorphology;

    @Autowired
    public WordTransformer(RussianLuceneMorphology russianLuceneMorphology) {
        this.russianLuceneMorphology = russianLuceneMorphology;
    }

    public Word wordTo2Word(WordTo wordTo) {
        Word person = new Word();
        String[] nameParts = wordTo.getV().toLowerCase().split(" ");
        for (String part : nameParts) {
            person.addNamePart(russianLuceneMorphology.getNormalForms(part).get(0));
        }
        person.setTag(wordTo.getNer());
        return person;
    }

}
