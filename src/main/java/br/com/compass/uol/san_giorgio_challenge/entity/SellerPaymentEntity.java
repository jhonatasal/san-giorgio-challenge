package br.com.compass.uol.san_giorgio_challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerPaymentEntity {
    private UUID sellerCode;
    private List<PaymentEntity> payments;
}
