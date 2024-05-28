package br.com.fiap.auth.controller;

import br.com.fiap.auth.config.security.TokenService;
import br.com.fiap.auth.dto.AuthDto;
import br.com.fiap.auth.dto.ExibirDto;
import br.com.fiap.auth.dto.LoginDto;
import br.com.fiap.auth.dto.RegistrarDto;
import br.com.fiap.auth.model.Usuario;
import br.com.fiap.auth.repository.UsuarioRepository;
import br.com.fiap.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDto authDto){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        authDto.email(),
                        authDto.senha()
                );

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDto(token));
    }

//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ExibirDto registrar(@RequestBody @Valid RegistrarDto registrarDto){
//        ExibirDto usuarioExibicaoDto = null;
//        usuarioExibicaoDto = authService.registrar(registrarDto);
//
//        return usuarioExibicaoDto;
//    }


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegistrarDto registrarDto){
        return authService.register(registrarDto);
    }
}
