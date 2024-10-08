package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SellerPaymentRequestDTO {

    private UUID sellerCode;
    private List<PaymentRequestDTO> payments;

}
