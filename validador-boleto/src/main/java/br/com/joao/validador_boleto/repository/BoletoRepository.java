package br.com.joao.validador_boleto.repository;

import br.com.joao.validador_boleto.entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<BoletoEntity, Long> {
}
