package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {

    @NotNull(message = "chargeCode must not be null")
    private UUID chargeCode;

    @NotNull(message = "amountPaid must not be null")
    @Positive(message = "amountPaid must be positive")
    private BigDecimal amountPaid;

}
