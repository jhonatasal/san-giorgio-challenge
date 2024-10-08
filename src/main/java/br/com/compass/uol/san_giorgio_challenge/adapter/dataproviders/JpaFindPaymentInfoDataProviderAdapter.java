package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.repository.PaymentInfoRepository;
import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.mapper.PaymentInfoMapper;
import br.com.compass.uol.san_giorgio_challenge.usecase.gateway.FindPaymentInfoGateway;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaFindPaymentInfoDataProviderAdapter implements FindPaymentInfoGateway {

    private final Logger LOGGER = LoggerFactory.getLogger(JpaFindPaymentInfoDataProviderAdapter.class);

    private final PaymentInfoRepository paymentInfoRepository;

    private final PaymentInfoMapper paymentInfoMapper;

    @Override
    public PaymentInfo execute(UUID chargeCode) {
        LOGGER.info(String.format("Finding payment %s", chargeCode));
        var paymentInfo = paymentInfoRepository.findById(chargeCode);
        return paymentInfo.map(paymentInfoMapper::toModel).orElse(null);
    }
}
