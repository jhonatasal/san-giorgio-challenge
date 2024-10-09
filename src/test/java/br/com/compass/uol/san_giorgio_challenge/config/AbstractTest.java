package br.com.compass.uol.san_giorgio_challenge.config;

import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.PaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.entity.PaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.entity.SellerPaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Profile("test")
public abstract class AbstractTest {


    public PaymentEntity paymentEntityDefault() {
        return PaymentEntity.builder()
                .amountPaid(new BigDecimal("33.90"))
                .chargeCode(UUID.randomUUID()).build();
    }

    public SellerPaymentEntity sellerPaymentEntityDefault(List<PaymentEntity> payments) {
        return SellerPaymentEntity.builder()
                .sellerCode(UUID.randomUUID())
                .payments(payments).build();
    }

    public PaymentInfo paymentInfoDefault(UUID chargeCode) {
        return PaymentInfo.builder()
                .amount(new BigDecimal("33.90"))
                .chargeCode(chargeCode)
                .build();
    }

    public SellerInfo sellerInfoDefault(UUID sellerCode) {
        return SellerInfo.builder()
                .sellerCode(sellerCode)
                .name("JOSE")
                .build();
    }

    public PaymentRequestDTO paymentRequestDTODefault() {
        return PaymentRequestDTO.builder()
                .amountPaid(new BigDecimal("33.90"))
                .chargeCode(UUID.randomUUID()).build();
    }

    public SellerPaymentRequestDTO sellerPaymentRequestDTODefault(List<PaymentRequestDTO> payments) {
        return SellerPaymentRequestDTO.builder()
                .sellerCode(UUID.randomUUID())
                .payments(payments).build();
    }


}
