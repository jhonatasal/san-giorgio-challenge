package br.com.compass.uol.san_giorgio_challenge.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class SellerPaymentEntity {
    private UUID sellerCode;
    private List<PaymentEntity> payments;
}
