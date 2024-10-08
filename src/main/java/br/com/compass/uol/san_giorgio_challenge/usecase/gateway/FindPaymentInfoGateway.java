package br.com.compass.uol.san_giorgio_challenge.usecase.gateway;

import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;

import java.util.UUID;

public interface FindPaymentInfoGateway {

    PaymentInfo execute(UUID chargeCode);
}
