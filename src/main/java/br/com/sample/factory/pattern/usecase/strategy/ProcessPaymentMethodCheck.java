package br.com.sample.factory.pattern.usecase.strategy;

import br.com.sample.factory.pattern.domain.Payment;
import br.com.sample.factory.pattern.usecase.CalculatePayment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessPaymentMethodCheck implements ProcessPaymentStrategy {

    private final CalculatePayment calculatePayment;

    @Override
    public Payment execute(final Payment payment) {
        log.info("Processa o método de pagamento {}", payment.getPaymentMethod().toString());
        return calculatePayment.execute(payment);
    }
}
