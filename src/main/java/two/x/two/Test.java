package two.x.two;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import two.x.two.client.WordFromTextClient;
import two.x.two.client.dto.WordTo;
import two.x.two.client.transformer.WordTransformer;
import two.x.two.repository.WordRepository;
import two.x.two.repository.entry.Word;

@Component
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    static String text1 = " Однажды весною, в час небывало жаркого заката, в Москве, на Патриарших прудах, появились " +
            "два гражданина. Первый из них, одетый в летнюю серенькую пару, был маленького роста, упитан, лыс, свою " +
            "приличную шляпу пирожком нес в руке, а на хорошо выбритом лице его помещались сверхъестественных " +
            "размеров очки в черной роговой оправе. Второй – плечистый, рыжеватый, вихрастый молодой человек в " +
            "заломленной на затылок клетчатой кепке – был в ковбойке, жеваных белых брюках и в черных тапочках.\n" +
            "\n" +
            "Первый был не кто иной, как Михаил Александрович Берлиоз, председатель правления одной из крупнейших " +
            "московских литературных ассоциаций, сокращенно именуемой МАССОЛИТ, и редактор толстого художественного " +
            "журнала, а молодой спутник его – поэт Иван Николаевич Понырев, пишущий под псевдонимом Бездомный.\n" +
            "\n" +
            "Попав в тень чуть зеленеющих лип, писатели первым долгом бросились к пестро раскрашенной будочке с " +
            "надписью «Пиво и воды».\n" +
            "\n" +
            "Да, следует отметить первую странность этого страшного майского вечера. Не только у будочки, но и во " +
            "всей аллее, параллельной Малой Бронной улице, не оказалось ни одного человека. В тот час, когда уж, " +
            "кажется, и сил не было дышать, когда солнце, раскалив Москву, в сухом тумане валилось куда-то за Садовое" +
            " кольцо, – никто не пришел под липы, никто не сел на скамейку, пуста была аллея.";
    private final WordRepository wordRepository;
    private final WordFromTextClient wordFromTextClient;
    private final WordTransformer wordTransformer;

    @Autowired
    public Test(WordRepository wordRepository, WordFromTextClient wordFromTextClient, WordTransformer wordTransformer) {
        this.wordRepository = wordRepository;
        this.wordFromTextClient = wordFromTextClient;
        this.wordTransformer = wordTransformer;
    }

    @Bean
    public int testOurSystem() throws Exception {
        wordRepository.deleteAll();
        List<WordTo> wordTos = new ArrayList<>();
        wordTos.addAll(wordFromTextClient.getWords(text1));
        for (WordTo wordTo : wordTos) {
            Word word = wordTransformer.wordTo2Word(wordTo);
            wordRepository.insert(word);

        }
        return 0;
    }
}
