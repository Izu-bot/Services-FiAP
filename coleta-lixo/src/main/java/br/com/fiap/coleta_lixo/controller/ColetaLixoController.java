package br.com.fiap.coleta_lixo.controller;

import br.com.fiap.coleta_lixo.dto.CadastroDto;
import br.com.fiap.coleta_lixo.dto.ExibicaoDto;
import br.com.fiap.coleta_lixo.service.ColetaLixoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coleta-lixo")
public class ColetaLixoController {

    @Autowired
    private ColetaLixoService service;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ExibicaoDto cadastrar(@RequestBody CadastroDto cadastroDto){
        return service.cadastrar(cadastroDto);
    }

    @GetMapping("/lixeiras")
    @ResponseStatus(HttpStatus.OK)
    public List<ExibicaoDto> listarTudo(){
        return service.listarTodos();
    }

    @GetMapping("/lixeiras/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExibicaoDto> buscarId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(service.buscarId(id));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExibicaoDto> atualizar(@RequestBody CadastroDto cadastroDto){
        try{
            ExibicaoDto exibicaoDto = service.atualizar(cadastroDto);
            return ResponseEntity.ok(exibicaoDto);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
