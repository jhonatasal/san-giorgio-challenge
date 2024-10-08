package br.com.compass.uol.san_giorgio_challenge.usecase.model;

import lombok.Builder;

import java.util.UUID;
@Builder
public class SellerInfo {
    private String name;

    private UUID sellerCode;
}
