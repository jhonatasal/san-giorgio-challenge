package br.com.compass.uol.san_giorgio_challenge.usecase.gateway;

import br.com.compass.uol.san_giorgio_challenge.entity.SellerPaymentEntity;

public interface SendPaymentGateway {
    void execute(SellerPaymentEntity paymentEntity);
}
