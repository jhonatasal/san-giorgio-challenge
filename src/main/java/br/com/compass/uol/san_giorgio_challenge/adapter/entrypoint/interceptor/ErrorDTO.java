package br.com.compass.uol.san_giorgio_challenge.adapter.entrypoint.interceptor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {

    private String message;
    private Integer code;

}

