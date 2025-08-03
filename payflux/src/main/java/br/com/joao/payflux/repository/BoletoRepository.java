package br.com.joao.payflux.repository;

import br.com.joao.payflux.entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository<BoletoEntity, Long> {
    Optional<BoletoEntity> findByCodigoBarras(String codigoBarras);
}
