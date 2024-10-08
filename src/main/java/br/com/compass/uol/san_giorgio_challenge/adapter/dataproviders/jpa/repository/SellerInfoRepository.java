package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity.SellerInfoTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerInfoRepository extends JpaRepository<SellerInfoTable, UUID> {
}
