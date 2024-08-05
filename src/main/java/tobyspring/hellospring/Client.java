package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.payment.Payment;
import tobyspring.hellospring.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 내가 만든 ObjectFactory의 설정정보를 기반으로 Bean 생성
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment1 = paymentService.prepare(1L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment1 ===> " + payment1);
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment2 ===> " + payment2);
        TimeUnit.SECONDS.sleep(4);

        Payment payment3 = paymentService.prepare(1L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment3 ===> " + payment3);
    }
}
