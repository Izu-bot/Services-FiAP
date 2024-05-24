package br.com.fiap.coleta_lixo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_coleta_lixo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ColetaLixo {

    @Id
    @Column(name = "numero_lixeira")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numeroLixeira;

    String endereco;

    @Column(name = "data_coleta")
    LocalDate dataColeta;

    @Column(name = "lixeira_cheia")
    @Enumerated(EnumType.STRING)
    Coletando lixeiraCheia;

    @Column(name = "processo_coleta")
    @Enumerated(EnumType.STRING)
    Coletando processoColeta;

}
