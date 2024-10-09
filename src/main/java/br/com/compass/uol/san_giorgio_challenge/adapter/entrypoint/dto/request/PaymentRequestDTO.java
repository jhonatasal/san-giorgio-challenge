package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

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
    private UUID chargeCode;
    private BigDecimal amountPaid;
}
