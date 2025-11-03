package com.controledeinvestimento.config;

import com.controledeinvestimento.domain.Usuario;
import com.controledeinvestimento.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner seedAdmin(UsuarioRepository usuarios, PasswordEncoder encoder){
        return args -> {
            String email = "miller.marcelino3@gmail.com";
            String senhaPlano = "S3nh@@nh";
            usuarios.findByEmail(email).ifPresentOrElse(
                    u -> {},
                    () -> {
                        Usuario admin = new Usuario();
                        admin.setEmail(email);
                        admin.setNome("Administrador");
                        admin.setSenhaHash(encoder.encode(senhaPlano));
                        usuarios.save(admin);
                    }
            );
        };
    }
}
