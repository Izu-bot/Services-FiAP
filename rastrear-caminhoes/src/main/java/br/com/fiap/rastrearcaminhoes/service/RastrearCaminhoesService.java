package br.com.fiap.rastrearcaminhoes.service;

import br.com.fiap.rastrearcaminhoes.dto.CadastroDto;
import br.com.fiap.rastrearcaminhoes.dto.ExibicaoDto;
import br.com.fiap.rastrearcaminhoes.model.ColetandoLixo;
import br.com.fiap.rastrearcaminhoes.model.RastrearCaminhoes;
import br.com.fiap.rastrearcaminhoes.repository.RastrearCaminhoesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RastrearCaminhoesService {

    @Autowired
    private RastrearCaminhoesRepository repository;

    public ExibicaoDto cadastrar(CadastroDto cadastroDto){
        // Cria um objeto vazio do tipo RastrearCaminhoes(classe modelo)
        RastrearCaminhoes rastrearCaminhoes = new RastrearCaminhoes();
        // Copia as propriedades
        BeanUtils.copyProperties(cadastroDto, rastrearCaminhoes);

        rastrearCaminhoes.setColetandoLixo(ColetandoLixo.NAO);

        LocalDateTime dataHora = LocalDateTime.now();
        rastrearCaminhoes.setDataHora(dataHora);

        // Retorna com o ExibicaoDto
        return new ExibicaoDto(repository.save(rastrearCaminhoes));
    }

    public List<ExibicaoDto> listarTodosCaminhoes(){
        return repository
                .findAll()
                .stream()
                .map(ExibicaoDto::new)
                .toList();
    }

    public ExibicaoDto buscarId(Long id){
        Optional<RastrearCaminhoes> caminhoesOptional = repository.findById(id);

        if (caminhoesOptional.isPresent()) {
           return new ExibicaoDto(caminhoesOptional.get());
        } else {
            throw new RuntimeException("Número do caminhão não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<RastrearCaminhoes> caminhoesOptional = repository.findById(id);

        if(caminhoesOptional.isPresent()){
            repository.delete(caminhoesOptional.get());
        } else {
            throw new RuntimeException("Número do caminhão não encontrado");
        }
    }

    public ExibicaoDto atualizar(CadastroDto cadastroDto){
        Optional<RastrearCaminhoes> caminhoesOptional = repository.findById(cadastroDto.numeroCaminhao());

        if(caminhoesOptional.isPresent()){
            RastrearCaminhoes caminhao = new RastrearCaminhoes();
            BeanUtils.copyProperties(cadastroDto, caminhao);

            LocalDateTime dataHora = LocalDateTime.now();
            caminhao.setDataHora(dataHora);

            return new ExibicaoDto(repository.save(caminhao));
        } else {
            throw new RuntimeException("Não foi possivel rastrear este caminhão :(");
        }
    }

}
