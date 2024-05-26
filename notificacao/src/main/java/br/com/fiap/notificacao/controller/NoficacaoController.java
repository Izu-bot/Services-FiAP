package br.com.fiap.notificacao.controller;

import br.com.fiap.notificacao.dto.CadastroDto;
import br.com.fiap.notificacao.dto.ExibicaoDto;
import br.com.fiap.notificacao.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacao")
public class NoficacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ExibicaoDto cadastrar(@RequestBody CadastroDto cadastroDto){
        return service.cadastrar(cadastroDto);
    }

    @GetMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public List<ExibicaoDto> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/moradores/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExibicaoDto buscarId(@PathVariable Long id){
        return service.buscarId(id);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ExibicaoDto atualizar(@RequestBody CadastroDto cadastroDto){
        return service.atualizar(cadastroDto);
    }
}
