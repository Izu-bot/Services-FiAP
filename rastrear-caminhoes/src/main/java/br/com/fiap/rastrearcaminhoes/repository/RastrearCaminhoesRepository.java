package br.com.fiap.rastrearcaminhoes.repository;

import br.com.fiap.rastrearcaminhoes.model.RastrearCaminhoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RastrearCaminhoesRepository extends JpaRepository<RastrearCaminhoes, Long> {
}
