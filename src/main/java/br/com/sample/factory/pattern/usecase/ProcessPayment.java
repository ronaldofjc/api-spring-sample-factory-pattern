package br.com.sample.factory.pattern.usecase;

import br.com.sample.factory.pattern.domain.Payment;
import br.com.sample.factory.pattern.usecase.strategy.ProcessPaymentFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessPayment {

    private final ProcessPaymentFactory processPaymentFactory;

    public Payment execute(final Payment payment) {
        return processPaymentFactory.create(payment.getPaymentMethod()).execute(payment);
    }
}
