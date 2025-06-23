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
        // Verifica se o usuário já existe para evitar duplicidade
        if (userRepository.findByEmail("teste@teste.com").isEmpty()) {
            User user = new User();
            user.setName("Usuário Teste");
            user.setEmail("teste@teste.com");
            user.setPassword(encoder.encode("123456")); // senha criptografada
            user.setRole("USER");
            userRepository.save(user);
            System.out.println("Usuário de teste criado: teste@teste.com / 123456");
        }
    };
}

}
