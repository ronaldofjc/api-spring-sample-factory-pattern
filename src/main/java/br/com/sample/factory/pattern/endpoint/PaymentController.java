package br.com.sample.factory.pattern.endpoint;


import br.com.sample.factory.pattern.domain.Payment;
import br.com.sample.factory.pattern.usecase.ProcessPayment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Tag(name = "Payment")
@RequiredArgsConstructor
@RequestMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    private final ProcessPayment processPayment;

    @PostMapping
    @Operation(summary = "Realiza o processamento de um método de pagamento")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content),
            @ApiResponse(responseCode = "422", description = "Business exception", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    public Payment processPayment(@Valid @RequestBody final Payment payment) {
        log.info("PAYLOAD - Process Payment {}", payment.toString());
        return processPayment.execute(payment);
    }
}
