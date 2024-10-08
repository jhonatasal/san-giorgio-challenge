package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class SellerInfoTable {
    private UUID sellerCode;

    private String name;
}
