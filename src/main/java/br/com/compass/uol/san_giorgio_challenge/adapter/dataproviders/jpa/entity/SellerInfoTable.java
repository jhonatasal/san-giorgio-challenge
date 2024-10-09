package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "seller_info")
@Data
public class SellerInfoTable {
    @Id
    private UUID sellerCode;

    private String name;
}
