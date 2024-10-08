package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class PaymentDTO {
    private UUID chargeCode;
    private BigDecimal amountPaid;
}
