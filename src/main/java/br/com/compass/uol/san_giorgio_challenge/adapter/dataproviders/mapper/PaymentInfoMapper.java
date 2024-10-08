package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.mapper;

import br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.jpa.entity.PaymentInfoTable;
import br.com.compass.uol.san_giorgio_challenge.usecase.model.PaymentInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentInfoMapper {
    PaymentInfo toModel(PaymentInfoTable paymentInfo);
}
