package tobyspring.hellospring.ex_rate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import tobyspring.hellospring.payment.ExRateProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * 요구사항 : 추후 환율이 필요한 기능이 많아질 것을 우려하여
 * Cache를 사용하여 매번 API 호출하지 않도록 보완한다.
 *
 * 기존 코드를 수정하지 않고 데코레이터 패턴으로 요구사항을 만족시킨다.
 */
@Component
public class WebApiExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
            URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = bufferedReader.lines().collect(Collectors.joining());
            bufferedReader.close();

            ObjectMapper mapper = new ObjectMapper();
            ExRateData data = mapper.readValue(response, ExRateData.class);

            System.out.println("API ExRate : " + data.rates().get("KRW"));
            return data.rates().get("KRW");
    }
}
