package br.com.fiap.notificacao.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_notificacao_morador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String endereco;

    @Column(name = "dia_coleta_organico")
    @Enumerated(EnumType.STRING)
    ColetaEnum diaColetaOrganica;

    @Column(name = "dia_coleta_plastico")
    @Enumerated(EnumType.STRING)
    ColetaEnum diaColetaPlastico;
}
