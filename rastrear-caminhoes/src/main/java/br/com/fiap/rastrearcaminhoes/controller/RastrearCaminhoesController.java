package br.com.fiap.rastrearcaminhoes.controller;

import br.com.fiap.rastrearcaminhoes.dto.CadastroDto;
import br.com.fiap.rastrearcaminhoes.dto.ExibicaoDto;
import br.com.fiap.rastrearcaminhoes.service.RastrearCaminhoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastrear-caminhoes")
public class RastrearCaminhoesController {

    @Autowired
    private RastrearCaminhoesService service;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ExibicaoDto cadastrar(@RequestBody CadastroDto cadastroDto) {
        return service.cadastrar(cadastroDto);
    }

    @GetMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public List<ExibicaoDto> listarTodosCaminhoes() {
        return service.listarTodosCaminhoes();
    }

    @GetMapping("/caminhoes/{numeroCaminhao}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExibicaoDto> buscarNumeroCaminhao(@PathVariable Long numeroCaminhao) {
        try {
            return ResponseEntity.ok(service.buscarId(numeroCaminhao));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/caminhoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExibicaoDto> atualizar(@RequestBody CadastroDto cadastroDto){
        try {
            ExibicaoDto exibicaoDto = service.atualizar(cadastroDto);
            return ResponseEntity.ok(exibicaoDto);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
