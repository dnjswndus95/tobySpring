package tobyspring.hellospring.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

// 레코드에 있지 않은 프로퍼티에 대해 무시
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(
        String result,
        Map<String, BigDecimal> rates
) {
}
