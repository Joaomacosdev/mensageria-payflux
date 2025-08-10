package br.com.joao.payflux.service;

import br.com.joao.payflux.dto.BoletoDTO;
import br.com.joao.payflux.entity.BoletoEntity;
import br.com.joao.payflux.entity.enums.SituacaoBoleto;
import br.com.joao.payflux.exception.ApplicationException;
import br.com.joao.payflux.mapper.BoletoMapper;
import br.com.joao.payflux.repository.BoletoRepository;
import br.com.joao.payflux.service.kafka.BoletoProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;
    private final BoletoProducer boletoProducer;

    public BoletoService(BoletoRepository boletoRepository, BoletoProducer boletoProducer) {
        this.boletoRepository = boletoRepository;
        this.boletoProducer = boletoProducer;
    }

    public BoletoDTO salvar(String codigoBarras) {
        var boletoOptional = boletoRepository.findByCodigoBarras(codigoBarras);
        if (boletoOptional.isPresent()) {
            throw new ApplicationException("Já existe uma solicitação de pagamento para esse boleto");
        }

        var boletoEntity = BoletoEntity.builder()
                .codigoBarras(codigoBarras)
                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        boletoRepository.save(boletoEntity);
        boletoProducer.enviarMensagem(BoletoMapper.toAvro(boletoEntity));
        return BoletoMapper.toDTO(boletoEntity);


    }
}
