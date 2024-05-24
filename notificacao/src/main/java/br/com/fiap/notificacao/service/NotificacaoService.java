package br.com.fiap.notificacao.service;

import br.com.fiap.notificacao.dto.CadastroDto;
import br.com.fiap.notificacao.dto.ExibicaoDto;
import br.com.fiap.notificacao.model.ColetaEnum;
import br.com.fiap.notificacao.model.Notificacao;
import br.com.fiap.notificacao.repository.NotificacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    public ExibicaoDto cadastrar(CadastroDto cadastroDto){
        Notificacao notificacao = new Notificacao();
        BeanUtils.copyProperties(cadastroDto, notificacao);

        notificacao.setDiaColetaOrganica(ColetaEnum.NAO);
        notificacao.setDiaColetaPlastico(ColetaEnum.NAO);

        return new ExibicaoDto(repository.save(notificacao));
    }

    public List<ExibicaoDto> listarTodos(){
        return repository
                .findAll()
                .stream()
                .map(ExibicaoDto::new)
                .toList();
    }

    public ExibicaoDto buscarId(Long id){
        Optional<Notificacao> notificacaoOptional = repository.findById(id);

        if(notificacaoOptional.isPresent()){
            return new ExibicaoDto(notificacaoOptional.get());
        } else {
            throw new RuntimeException("Não achamos um morador com esse id no sistema!");
        }
    }

    public void deletar(Long id){
        Optional<Notificacao> notificacaoOptional = repository.findById(id);

        if(notificacaoOptional.isPresent()){
            repository.delete(notificacaoOptional.get());
        } else {
            throw new RuntimeException("Não achamos um morador com esse id no sistema!");
        }
    }

    public ExibicaoDto atualizar(CadastroDto cadastroDto){
        Optional<Notificacao> notificacaoOptional = repository.findById(cadastroDto.id());

        if(notificacaoOptional.isPresent()){
            Notificacao notificacao = new Notificacao();
            BeanUtils.copyProperties(cadastroDto, notificacao);

            return new ExibicaoDto(repository.save(notificacao));
        } else {
            throw new RuntimeException("Não achamos um morador com esse id no sistema!");
        }
    }

}
