package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository.SellerInfoRepository;
import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.mapper.SellerInfoMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindSellerGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.SellerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;



@Repository
public class JpaFindSellerInfoDataProviderAdapter implements FindSellerGateway {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaFindSellerInfoDataProviderAdapter.class);

    @Autowired
    private  SellerInfoRepository sellerInfoRepository;

    @Autowired
    private  SellerInfoMapper sellerInfoMapper;

    @Override
    public SellerInfo execute(UUID sellerCode) {
        LOGGER.info(String.format("Finding seller %s", sellerCode));
        var sellerInfo = sellerInfoRepository.findById(sellerCode);
        return sellerInfo.map(sellerInfoMapper::toModel).orElse(null);
    }
}
