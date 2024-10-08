package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SellerPaymentResponseDTO {

    private UUID sellerCode;
    private List<PaymentResponseDTO> payments;

}
