package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerPaymentRequestDTO {

    @NotNull(message = "sellerCode must not be null")
    private UUID sellerCode;

    @Valid
    @NotEmpty(message = "payments must not be empty")
    private List<PaymentRequestDTO> payments;

}
