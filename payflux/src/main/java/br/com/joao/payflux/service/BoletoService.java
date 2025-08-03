package br.com.joao.payflux.service;

import br.com.joao.payflux.dto.BoletoDTO;
import br.com.joao.payflux.entity.BoletoEntity;
import br.com.joao.payflux.entity.enums.SituacaoBoleto;
import br.com.joao.payflux.mapper.BoletoMapper;
import br.com.joao.payflux.repository.BoletoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public BoletoDTO salvar(String codigoBarras) {
        var boletoOptional = boletoRepository.findByCodigoBarras(codigoBarras);
        if (boletoOptional.isPresent()) {
            throw new RuntimeException("Já existe uma solicitação de pagamento para esse boleto");
        }

        var boletoEntity = BoletoEntity.builder()
                .codigoBarras(codigoBarras)
                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        boletoRepository.save(boletoEntity);
        return BoletoMapper.toDTO(boletoEntity);

    }
}
