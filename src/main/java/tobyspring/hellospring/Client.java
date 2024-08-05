package tobyspring.hellospring;

import tobyspring.hellospring.application.domain.Payment;
import tobyspring.hellospring.application.service.factory.ObjectFactory;
import tobyspring.hellospring.application.service.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        ObjectFactory objectFactory = new ObjectFactory();

        // 클라이언트에서 환율정책을 설정할 수 있도록 수정
        //PaymentService paymentService = new PaymentService(new WebApiExRateProvider());
        PaymentService paymentService = objectFactory.paymentService();


        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
