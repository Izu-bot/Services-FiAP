package br.com.fiap.rastrearcaminhoes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_rastrear")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RastrearCaminhoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_caminhao")
    private Long numeroCaminhao;

    @Column(name = "endereco_atual")
    private String enderecoAtual;

    private String nome;

    @Column(name = "coletando_lixo")
    @Enumerated(EnumType.STRING)
    private ColetandoLixo coletandoLixo;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
}
