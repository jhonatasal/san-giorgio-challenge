package br.com.compass.uol.san_giorgio_challenge.usecase.gateway;

import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;

import java.util.UUID;

public interface FindSellerGateway {
    SellerInfo execute(UUID sellerCode);
}
