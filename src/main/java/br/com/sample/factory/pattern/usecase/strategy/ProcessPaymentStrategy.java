package br.com.sample.factory.pattern.usecase.strategy;

import br.com.sample.factory.pattern.domain.Payment;

public interface ProcessPaymentStrategy {

    Payment execute(Payment payment);
}
