package tobyspring.hellospring;

import tobyspring.hellospring.application.domain.Payment;
import tobyspring.hellospring.application.service.PaymentService;
import tobyspring.hellospring.application.service.SimpleExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
