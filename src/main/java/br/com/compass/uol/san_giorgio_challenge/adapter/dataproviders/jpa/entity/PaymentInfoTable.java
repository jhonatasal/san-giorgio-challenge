package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class PaymentInfoTable {

    @Id
    private UUID chargeCode;

    private BigDecimal amount;

}
