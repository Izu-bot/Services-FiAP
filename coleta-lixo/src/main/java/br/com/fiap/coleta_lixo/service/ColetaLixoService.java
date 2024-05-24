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
import java.util.List;
import java.util.Optional;

@Service
public class ColetaLixoService {

    @Autowired
    private ColetaLixoRepository repository;

    public ExibicaoDto cadastrar(CadastroDto cadastroDto){
        ColetaLixo coletaLixo = new ColetaLixo();
        BeanUtils.copyProperties(cadastroDto, coletaLixo);

        coletaLixo.setProcessoColeta(Coletando.NAO);
        coletaLixo.setLixeiraCheia(Coletando.NAO);

        LocalDate data = LocalDate.now();

        coletaLixo.setDataColeta(data);

        return new ExibicaoDto(repository.save(coletaLixo));
    }

    public List<ExibicaoDto> listarTodos(){
        return repository
                .findAll()
                .stream()
                .map(ExibicaoDto::new)
                .toList();
    }

    public ExibicaoDto buscarId(Long numeroLixeira){
        Optional<ColetaLixo> coletaLixoOptional = repository.findById(numeroLixeira);

        if(coletaLixoOptional.isPresent()){
            return new ExibicaoDto(coletaLixoOptional.get());
        } else {
            throw new RuntimeException("Número da lixeira não encontrado no sistema!");
        }
    }

    public void excluir(Long numeroLixeira){
        Optional<ColetaLixo> coletaLixoOptional = repository.findById(numeroLixeira);

        if(coletaLixoOptional.isPresent()){
            repository.delete(coletaLixoOptional.get());
        } else {
            throw new RuntimeException("Número da lixeira não encontrado no sistema!");
        }
    }

    public ExibicaoDto atualizar(CadastroDto cadastroDto){
        Optional<ColetaLixo> coletaLixoOptional = repository.findById(cadastroDto.numeroLixeira());

        if(coletaLixoOptional.isPresent()){
            ColetaLixo coletaLixo = new ColetaLixo();
            BeanUtils.copyProperties(cadastroDto, coletaLixo);

            LocalDate data = LocalDate.now();
            coletaLixo.setDataColeta(data);
            return new ExibicaoDto(repository.save(coletaLixo));
        } else {
            throw new RuntimeException("Número da lixeira não encontrado no sistema!");
        }
    }
}
