package tobyspring.hellospring.application.service.payment;

import org.springframework.stereotype.Component;
import tobyspring.hellospring.application.domain.Payment;
import tobyspring.hellospring.application.service.ex_rate.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PaymentService {

    private final ExRateProvider exRateProvider;

    public PaymentService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }

    // Payment 반환
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = exRateProvider.getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    // PaymentService에서 환율을 가져오는 기능까지 가지고 있을 필요가 없다.
    // 책임을 분리하자
    //abstract BigDecimal getExRate(String currency) throws IOException;
}
