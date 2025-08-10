package br.com.joao.payflux.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoletoRequestDTO {

    @NotNull(message = "não pode ser nullo")
    @NotEmpty(message = "Não pode ser vazio")
    private String codigoBarras;
}
