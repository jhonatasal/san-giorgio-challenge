package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class PaymentRequestDTO {
    private UUID chargeCode;
    private BigDecimal amountPaid;
}
