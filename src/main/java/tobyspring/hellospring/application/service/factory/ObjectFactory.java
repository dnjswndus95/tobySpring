package tobyspring.hellospring.application.service.factory;

import tobyspring.hellospring.application.service.ex_rate.ExRateProvider;
import tobyspring.hellospring.application.service.ex_rate.WebApiExRateProvider;
import tobyspring.hellospring.application.service.payment.PaymentService;

public class ObjectFactory {
    public PaymentService paymentService() {
        return new PaymentService(this.exRateProvider());
    }

    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
