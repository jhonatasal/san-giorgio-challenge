package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.rest;

import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.SellerPaymentResponseDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.mapper.SellerPaymentMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.ValidatePaymentUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/seller/payment")
@Tag(name = "Seller Payment")
public class PaymentController {

    private final ValidatePaymentUseCase validatePaymentUseCase;

    private final SellerPaymentMapper sellerPaymentMapper;

    @PutMapping
    public ResponseEntity<SellerPaymentResponseDTO> validatePayment(@RequestBody @Valid SellerPaymentRequestDTO sellerPaymentRequest) {
        var sellerPaymentEntity = sellerPaymentMapper.toEntity(sellerPaymentRequest);
        sellerPaymentEntity = validatePaymentUseCase.execute(sellerPaymentEntity);

        var sellerPaymentResponse = sellerPaymentMapper.toResponse(sellerPaymentEntity);
        return ResponseEntity.ok(sellerPaymentResponse);
    }

}
