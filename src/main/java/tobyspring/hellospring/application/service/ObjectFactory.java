package tobyspring.hellospring.application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.application.service.ex_rate.CachedExRateProvider;
import tobyspring.hellospring.application.service.ex_rate.ExRateProvider;
import tobyspring.hellospring.application.service.ex_rate.SimpleExRateProvider;
import tobyspring.hellospring.application.service.ex_rate.WebApiExRateProvider;
import tobyspring.hellospring.application.service.payment.PaymentService;


@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider());
    }
    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
