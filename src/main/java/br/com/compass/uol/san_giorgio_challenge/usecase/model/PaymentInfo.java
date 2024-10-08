package br.com.compass.uol.san_giorgio_challenge.usecase.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record PaymentInfo(BigDecimal amount, UUID chargeCode) {
}
