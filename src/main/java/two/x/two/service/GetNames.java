package two.x.two.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import two.x.two.entity.NerResponce;
import two.x.two.entity.Word;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
public class GetNames {

    RestTemplate restTemplate = new RestTemplate();
    URI uri = URI.create("http://ner-ru.apphb.com/RESTProcessHandler.ashx");

    @Bean
    List<Word> get() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("text", text);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        NerResponce responce = restTemplate.postForEntity(uri, request, NerResponce.class)
                .getBody();
        return responce.getWords();
    }

    static String text = "В Петербурге перед судом предстанет высокопоставленный офицер Генерального штаба ВС РФ. СКР завершил расследование уголовного дела против главы военно-топографического управления Генштаба контр-адмирала Сергея Козлова, обвиняемого в превышении должностных полномочий и мошенничестве.\n" +
            "\"Следствием собрана достаточная доказательственная база, подтверждающая виновность контр-адмирала Козлова в инкриминируемых преступлениях, в связи с чем уголовное дело с утвержденным обвинительным заключением направлено в суд для рассмотрения по существу\", - рассказали следователи.\n" +
            "Кроме того, по инициативе следствия представителем Минобороны России к С.Козлову заявлен гражданский иск о возмещении причиненного государству ущерба на сумму свыше 27 млн руб.\n" +
            "По данным следователей, в июле 2010г. военный чиновник отдал подчиненному \"заведомо преступный приказ\" о заключении лицензионных договоров с компаниями \"Чарт-Пилот\" и \"Транзас\". Им необоснованно были переданы права на использование в коммерческих целях навигационных морских карт, являвшихся интеллектуальной собственностью РФ. В результате ущерб составил более 9,5 млн руб.\n" +
            "Контр-адмирал также умолчал о наличии у него в собственности квартиры в городе Истра Московской области. В результате в 2006г. центральной жилищной комиссии Минобороны и Управления делами президента РФ С.Козлов был признан нуждающимся в жилье и в 2008г. получил от государства квартиру в Москве площадью 72 кв. м и стоимостью 18,5 млн руб. Квартиру позднее приватизировала его падчерица.\n" +
            "Против С. Козлова возбуждено дело по п.\"в\" ч.3 ст.286 (превышение должностных полномочий, совершенное с причинением тяжких последствий) и ч.4 ст.159 (мошенничество, совершенное в особо крупном размере) УК РФ.";
}
