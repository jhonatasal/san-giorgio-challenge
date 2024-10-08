package br.com.compass.uol.san_giorgio_challenge.usecase.model;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentInfo(BigDecimal amount, UUID chargeCode) {
}
