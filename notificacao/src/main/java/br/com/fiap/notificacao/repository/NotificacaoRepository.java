package br.com.fiap.notificacao.repository;

import br.com.fiap.notificacao.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
