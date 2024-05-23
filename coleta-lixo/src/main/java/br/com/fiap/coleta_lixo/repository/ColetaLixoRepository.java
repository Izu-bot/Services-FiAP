package br.com.fiap.coleta_lixo.repository;

import br.com.fiap.coleta_lixo.model.ColetaLixo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColetaLixoRepository extends JpaRepository<ColetaLixo, Long> {
}
