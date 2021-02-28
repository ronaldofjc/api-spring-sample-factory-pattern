package br.com.sample.factory.pattern.usecase;

import br.com.sample.factory.pattern.domain.Payment;
import br.com.sample.factory.pattern.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
public class CalculatePayment {

    public Payment execute(final Payment payment) {
        final BigDecimal total = new BigDecimal(String.valueOf(payment.getTotalValue().subtract(payment.getPaymentValue())))
                .setScale(2, RoundingMode.HALF_EVEN);

        if (total.doubleValue() < 0.00) {
            log.error("Payment amount is greater than the total purchase. [PaymentValue: {}], [TotalValue: {}]",
                    payment.getPaymentValue(), payment.getTotalValue());
            throw new BusinessException("Payment amount is greater than the total purchase");
        }

        payment.setTotalValue(total);
        log.info("Payment Method calculated: [{}]", payment);
        return payment;
    }
}
