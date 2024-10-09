package br.com.compass.uol.san_giorgio_challenge.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

    private UUID chargeCode;
    private BigDecimal amountPaid;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    public void validateStatusPayment() {
        int comparison = amountPaid.compareTo(amount);

        switch (comparison) {
            case -1:
                paymentStatus = PaymentStatus.PARTIAL;
                break;
            case 0:
                paymentStatus = PaymentStatus.TOTAL;
                break;
            case 1:
                paymentStatus = PaymentStatus.EXCESS;
                break;
            default:
                throw new IllegalArgumentException("Invalid payment status");
        }
    }
}
