package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.rest;

import br.com.compass.uol.san_giorgio_challenge.usecase.ValidatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/payment")
public class PaymentController {

    private final ValidatePaymentUseCase validatePaymentUseCase;

    @PostMapping
    public ResponseEntity<Void> validatePayment() {

        return ResponseEntity.ok().build();
    }

}
