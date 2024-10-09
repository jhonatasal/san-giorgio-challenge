package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.rest;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.queue.SqsService;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.PaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.PaymentStatus;
import br.com.compass.uol.san_giorgio_challenge.config.AbstractTest;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PaymentControllerTest extends AbstractTest {

    @Autowired
    PaymentController paymentController;

    @MockBean
    FindPaymentInfoGateway findPaymentInfoGateway;

    @MockBean
    FindSellerGateway findSellerGateway;

    @MockBean
    SqsService sqsService;


    @Test
    public void givenValidSellerPaymentRequest_whenValidatePayment_thenReturnOkResponse() {
        PaymentRequestDTO paymentRequestDTO = paymentRequestDTODefault();
        SellerPaymentRequestDTO sellerPaymentRequestDTO = sellerPaymentRequestDTODefault(List.of(paymentRequestDTO));

        when(findPaymentInfoGateway.execute(paymentRequestDTO.getChargeCode()))
                .thenReturn(paymentInfoDefault(paymentRequestDTO.getChargeCode()));

        when(findSellerGateway.execute(sellerPaymentRequestDTO.getSellerCode()))
                .thenReturn(sellerInfoDefault(sellerPaymentRequestDTO.getSellerCode()));

        var sellerPaymentResponseDTO = paymentController.validatePayment(sellerPaymentRequestDTO).getBody();

        assertNotNull(sellerPaymentResponseDTO);
        assertEquals(PaymentStatus.TOTAL, sellerPaymentResponseDTO.getPayments().get(0).getPaymentStatus());

    }
}