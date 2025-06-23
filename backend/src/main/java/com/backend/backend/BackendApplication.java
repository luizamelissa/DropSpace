package com.backend.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
public CommandLineRunner run(UserRepository userRepository, BCryptPasswordEncoder encoder) {
    return args -> {
        try {
            userRepository.findByEmail("teste@teste.com").ifPresentOrElse(
                user -> System.out.println("Usuário de teste já existe."),
                () -> {
                    User user = new User();
                    user.setName("Usuário Teste");
                    user.setEmail("teste@teste.com");
                    user.setPassword(encoder.encode("123456"));
                    user.setRole("USER");
                    userRepository.save(user);
                    System.out.println("Usuário de teste criado com sucesso.");
                }
            );
        } catch (Exception e) {
            System.out.println("Erro ao criar usuário de teste: " + e.getMessage());
        }
    };
}


}
