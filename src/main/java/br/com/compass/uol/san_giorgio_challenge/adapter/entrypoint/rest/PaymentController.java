package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.rest;

import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.SellerPaymentResponseDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.mapper.SellerPaymentMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.ValidatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/seller/payment")
public class PaymentController {

    private final ValidatePaymentUseCase validatePaymentUseCase;

    private final SellerPaymentMapper sellerPaymentMapper;

    @PostMapping
    public ResponseEntity<SellerPaymentResponseDTO> validatePayment(SellerPaymentRequestDTO sellerPaymentRequest) {
        var sellerPaymentEntity = sellerPaymentMapper.toEntity(sellerPaymentRequest);
        sellerPaymentEntity = validatePaymentUseCase.execute(sellerPaymentEntity);

        var sellerPaymentResponse = sellerPaymentMapper.toResponse(sellerPaymentEntity);
        return ResponseEntity.ok(sellerPaymentResponse);
    }

}
