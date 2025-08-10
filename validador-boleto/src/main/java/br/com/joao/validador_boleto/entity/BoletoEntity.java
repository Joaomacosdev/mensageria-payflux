package br.com.joao.validador_boleto.entity;

import br.com.joao.validador_boleto.entity.enums.SituacaoBoleto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class BoletoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_barra")
    private String codigoBarras;

    @Column(name = "situacao_boleto")
    @Enumerated(EnumType.STRING)
    private SituacaoBoleto situacaoBoleto;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
