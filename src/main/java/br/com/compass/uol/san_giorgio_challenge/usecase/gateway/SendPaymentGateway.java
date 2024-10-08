package br.com.compass.uol.san_giorgio_challenge.usecase.gateway;

import br.com.compass.uol.san_giorgio_challenge.entity.PaymentEntity;

public interface SendPaymentGateway {
    void execute(PaymentEntity paymentEntity);
}
