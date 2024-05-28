package br.com.fiap.auth.service;

import br.com.fiap.auth.config.security.TokenService;
import br.com.fiap.auth.dto.AuthDto;
import br.com.fiap.auth.dto.ExibirDto;
import br.com.fiap.auth.dto.RegistrarDto;
import br.com.fiap.auth.model.Usuario;
import br.com.fiap.auth.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService implements UserDetailsService {


    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }

    public ResponseEntity<Object> register (@RequestBody RegistrarDto registrarDto){
        if (this.repository.findByEmail(registrarDto.email()) != null ) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registrarDto.senha());

        Usuario user = new Usuario(registrarDto.id(), registrarDto.email(), encryptedPassword, registrarDto.role());
        this.repository.save(user);
        return ResponseEntity.ok().build();
    }
}
