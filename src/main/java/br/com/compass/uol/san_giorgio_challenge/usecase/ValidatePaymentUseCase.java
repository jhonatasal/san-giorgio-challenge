package br.com.compass.uol.san_giorgio_challenge.usecase;

import br.com.compass.uol.san_giorgio_challenge.entity.PaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.entity.SellerPaymentEntity;
import br.com.compass.uol.san_giorgio_challenge.usecase.exception.PaymentNotFoundException;
import br.com.compass.uol.san_giorgio_challenge.usecase.exception.SellerNotFoundException;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.SendPaymentGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ValidatePaymentUseCase {

    private final Logger LOGGER = LoggerFactory.getLogger(ValidatePaymentUseCase.class);

    private final FindSellerGateway findSellerGateway;

    private final FindPaymentInfoGateway findPaymentInfoGateway;

    private final SendPaymentGateway sendPaymentGateway;

    public SellerPaymentEntity validate(SellerPaymentEntity sellerPaymentEntity) {
        var seller = findSellerGateway.execute(sellerPaymentEntity.getSellerCode());
        if (seller == null)
            throw new SellerNotFoundException("Seller not found");

        sellerPaymentEntity.getPayments().forEach(payment -> {
            PaymentInfo paymentInfo = findPaymentInfoGateway.execute(payment.getChargeCode());
            if (paymentInfo == null)
                throw new PaymentNotFoundException(String.format("Payment %s not found", payment.getChargeCode()));

            payment.setAmount(paymentInfo.amount());
            payment.validateStatusPayment();
        });

        sendPaymentGateway.execute(sellerPaymentEntity);

        return sellerPaymentEntity;
    }
}
