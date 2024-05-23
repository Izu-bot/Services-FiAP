package br.com.fiap.coleta_lixo.service;

import br.com.fiap.coleta_lixo.dto.CadastroDto;
import br.com.fiap.coleta_lixo.dto.ExibicaoDto;
import br.com.fiap.coleta_lixo.model.ColetaLixo;
import br.com.fiap.coleta_lixo.model.Coletando;
import br.com.fiap.coleta_lixo.repository.ColetaLixoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ColetaLixoService {

    @Autowired
    ColetaLixoRepository repository;

    public ExibicaoDto cadastrar(CadastroDto cadastroDto){
        ColetaLixo coletaLixo = new ColetaLixo();
        BeanUtils.copyProperties(cadastroDto, coletaLixo);

        coletaLixo.setProcessoColeta(Coletando.NAO);
        coletaLixo.setProcessoColeta(Coletando.NAO);

        LocalDate data = LocalDate.now();

        coletaLixo.setDataColeta(data);

        return new ExibicaoDto(repository.save(coletaLixo));
    }
}
