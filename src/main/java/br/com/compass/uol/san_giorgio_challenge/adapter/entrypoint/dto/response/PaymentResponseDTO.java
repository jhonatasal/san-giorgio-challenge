package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PaymentResponseDTO {
    private UUID chargeCode;
    private BigDecimal amountPaid;
    private PaymentStatus paymentStatus;
}
