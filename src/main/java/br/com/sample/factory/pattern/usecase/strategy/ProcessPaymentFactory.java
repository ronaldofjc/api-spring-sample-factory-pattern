package br.com.sample.factory.pattern.usecase.strategy;

import br.com.sample.factory.pattern.domain.PaymentMethod;
import br.com.sample.factory.pattern.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessPaymentFactory {

    private final BeanFactory beanFactory;

    public ProcessPaymentStrategy create(final PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case DINHEIRO:
                return beanFactory.getBean(ProcessPaymentMethodMoney.class);
            case CARTAO_DEBITO:
                return beanFactory.getBean(ProcessPaymentMethodDebitCard.class);
            case CARTAO_CREDITO:
                return beanFactory.getBean(ProcessPaymentMethodCreditCard.class);
            case CHEQUE:
                return beanFactory.getBean(ProcessPaymentMethodCheck.class);
            case CREDIARIO:
                return beanFactory.getBean(ProcessPaymentMethodInsurance.class);
            default:
                throw new BusinessException("Invalid payment method");
        }
    }
}
