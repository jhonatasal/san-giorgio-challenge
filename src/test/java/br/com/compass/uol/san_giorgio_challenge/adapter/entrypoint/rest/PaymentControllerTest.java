package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.rest;

import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.PaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.PaymentStatus;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.SellerPaymentResponseDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.mapper.SellerPaymentMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.SendPaymentGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PaymentControllerTest {

    @Autowired
    PaymentController paymentController;

    @Mock
    FindPaymentInfoGateway findPaymentInfoGateway;

    @Mock
    FindSellerGateway findSellerGateway;

    @Mock
    SendPaymentGateway sendPaymentGateway;


    @Test
    public void givenValidSellerPaymentRequest_whenValidatePayment_thenReturnOkResponse() {
        PaymentRequestDTO paymentRequestDTO = PaymentRequestDTO.builder()
                .amountPaid(new BigDecimal("33.90"))
                .chargeCode(UUID.randomUUID()).build();
        SellerPaymentRequestDTO sellerPaymentRequestDTO = SellerPaymentRequestDTO.builder()
                .sellerCode(UUID.randomUUID())
                .payments(List.of(paymentRequestDTO)).build();

        when(findPaymentInfoGateway.execute(paymentRequestDTO.getChargeCode()))
                .thenReturn(
                        PaymentInfo.builder()
                                .amount(new BigDecimal("33.90"))
                                .chargeCode(paymentRequestDTO.getChargeCode())
                                .build());

        when(findSellerGateway.execute(sellerPaymentRequestDTO.getSellerCode()))
                .thenReturn(SellerInfo.builder()
                        .sellerCode(sellerPaymentRequestDTO.getSellerCode())
                        .name("JOSE")
                        .build());

        var sellerPaymentResponseDTO = paymentController.validatePayment(sellerPaymentRequestDTO).getBody();

        assertNotNull(sellerPaymentResponseDTO);
        assertEquals(PaymentStatus.TOTAL, sellerPaymentResponseDTO.getPayments().get(0).getPaymentStatus());

    }
}