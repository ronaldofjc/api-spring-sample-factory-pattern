package br.com.sample.factory.pattern.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    @NotNull(message = "Field totalValue is mandatory")
    private BigDecimal totalValue;
    @NotNull(message = "Field paymentValue is mandatory")
    private BigDecimal paymentValue;
    @NotNull(message = "Field paymentMethod is mandatory")
    private PaymentMethod paymentMethod;
}
