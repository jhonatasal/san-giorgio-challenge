package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.queue.SqsService;
import br.com.compass.uol.san_giorgio_challenge.entity.PaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.SendPaymentGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsSendPaymentDataProviderAdapter implements SendPaymentGateway {

    private final Logger LOGGER = LoggerFactory.getLogger(SqsSendPaymentDataProviderAdapter.class);

    @Autowired
    private SqsService sqsService;

    @Override
    public void execute(PaymentEntity paymentEntity) {
        LOGGER.info("Sending payment to SQS");
        sqsService.sendMessage(String.valueOf(paymentEntity.getPaymentStatus()), paymentEntity);
    }
}
