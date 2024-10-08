package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity.PaymentInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfoTable, UUID> {
}
