package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.mapper;

import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.request.SellerPaymentRequestDTO;
import br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.dto.response.SellerPaymentResponseDTO;
import br.com.compass.uol.san_giorgio_challenge.entity.SellerPaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SellerPaymentMapper {
    SellerPaymentEntity toEntity(SellerPaymentRequestDTO sellerPaymentRequestDTO);

    SellerPaymentResponseDTO toResponse(SellerPaymentEntity sellerPaymentEntity);

}
