package br.com.joao.payflux.dto;

import br.com.joao.payflux.entity.enums.SituacaoBoleto;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoletoDTO {

    private Long id;
    private String codigoBarras;
    private SituacaoBoleto situacaoBoleto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
