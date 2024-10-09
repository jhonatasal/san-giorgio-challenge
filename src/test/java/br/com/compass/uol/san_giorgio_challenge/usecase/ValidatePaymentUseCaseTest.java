package br.com.compass.uol.san_giorgio_challenge.usecase;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.queue.SqsService;
import br.com.compass.uol.san_giorgio_challenge.config.AbstractTest;
import br.com.compass.uol.san_giorgio_challenge.entity.PaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.entity.PaymentStatus;
import br.com.compass.uol.san_giorgio_challenge.entity.SellerPaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ValidatePaymentUseCaseTest extends AbstractTest {

    @Autowired
    ValidatePaymentUseCase validatePaymentUseCase;

    @MockBean
    FindPaymentInfoGateway findPaymentInfoGateway;

    @MockBean
    FindSellerGateway findSellerGateway;

    @MockBean
    SqsService sqsService;

    @Test
    public void givenValidSellerPaymentRequest_whenValidatePayment_thenReturnOkResponse() {

        PaymentEntity paymentEntity = paymentEntityDefault();
        SellerPaymentEntity sellerPaymentEntity = sellerPaymentEntityDefault(List.of(paymentEntity));

        when(findPaymentInfoGateway.execute(paymentEntity.getChargeCode()))
                .thenReturn(paymentInfoDefault(paymentEntity.getChargeCode()));

        when(findSellerGateway.execute(sellerPaymentEntity.getSellerCode()))
                .thenReturn(sellerInfoDefault(sellerPaymentEntity.getSellerCode()));

        sellerPaymentEntity = validatePaymentUseCase.execute(sellerPaymentEntity);

        assertNotNull(sellerPaymentEntity);
        assertEquals(PaymentStatus.TOTAL, sellerPaymentEntity.getPayments().get(0).getPaymentStatus());
    }
}