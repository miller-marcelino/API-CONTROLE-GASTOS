package com.controledeinvestimento.controller;

import com.controledeinvestimento.domain.Usuario;
import com.controledeinvestimento.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
public class AuthController {

    private final UsuarioRepository usuarios;
    private final PasswordEncoder encoder;

    public AuthController(UsuarioRepository usuarios, PasswordEncoder encoder) {
        this.usuarios = usuarios;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        String username = body.getOrDefault("username", null);
        String email = body.getOrDefault("email", username);
        String password = body.getOrDefault("password", "");

        if(email == null || email.isBlank()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error","Email é obrigatório"));
        }

        Optional<Usuario> opt = usuarios.findByEmail(email);
        if(opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Credenciais inválidas"));
        }
        Usuario u = opt.get();
        if(!encoder.matches(password, u.getSenhaHash())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Credenciais inválidas"));
        }

        return ResponseEntity.ok(Map.of(
                "username", u.getEmail(),
                "name", Optional.ofNullable(u.getNome()).orElse("Usuário"),
                "token", "mock-token"
        ));
    }
}
