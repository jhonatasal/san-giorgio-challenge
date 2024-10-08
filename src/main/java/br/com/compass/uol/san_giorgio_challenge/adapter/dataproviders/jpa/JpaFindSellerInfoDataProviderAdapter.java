package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository.PaymentInfoRepository;
import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository.SellerInfoRepository;
import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.mapper.PaymentInfoMapper;
import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.mapper.SellerInfoMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JpaFindSellerInfoDataProviderAdapter implements FindSellerGateway {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaFindSellerInfoDataProviderAdapter.class);

    private final SellerInfoRepository sellerInfoRepository;

    private final SellerInfoMapper sellerInfoMapper;

    @Override
    public SellerInfo execute(UUID sellerCode) {
        LOGGER.info(String.format("Finding seller %s", sellerCode));
        var sellerInfo = sellerInfoRepository.findById(sellerCode);
        return sellerInfo.map(sellerInfoMapper::toModel).orElse(null);
    }
}
