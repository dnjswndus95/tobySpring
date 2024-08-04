package tobyspring.hellospring.application.service;

import tobyspring.hellospring.application.domain.Payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {

    private final WebApiExRateProvider exRateProvider;

    public PaymentService() {
        this.exRateProvider = new WebApiExRateProvider();
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
