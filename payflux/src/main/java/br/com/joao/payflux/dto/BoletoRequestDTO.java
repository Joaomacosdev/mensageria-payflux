package br.com.joao.payflux.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoletoRequestDTO {

    private String codigoBarras;
}
