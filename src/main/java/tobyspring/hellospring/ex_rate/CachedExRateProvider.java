package tobyspring.hellospring.ex_rate;

import tobyspring.hellospring.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *  PaymentService <-> Cached ExRateProvider </-> WebApiExRateProvider
 *                      *Decorator
 */

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;
    private BigDecimal cachedExRate;
    private LocalDateTime cacheExpiryTime;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if(cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())) {
            cachedExRate = target.getExRate(currency);
            cacheExpiryTime = LocalDateTime.now().plusSeconds(3L);
            System.out.println("Cache Updated!");
        }
        return cachedExRate;
    }
}
