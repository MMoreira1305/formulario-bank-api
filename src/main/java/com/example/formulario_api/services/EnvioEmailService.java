package com.example.formulario_api.services;

import com.example.formulario_api.domain.model.TokenEmail;
import com.example.formulario_api.repository.TokenEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EnvioEmailService {

    private final WebClient webClient;

    @Autowired
    private TokenEmailRepository repository;

    @Autowired
    private TokenService tokenService;

    public EnvioEmailService(@Value("${API_MENSAGERIA_URL}") String url) {
        this.webClient = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    public void enviarEmail(String email, String mensagem, String token) {
        this.deleteTokenEmail(email);

        // Corrigindo o JSON para o formato correto
        String jsonString = "{\"email\": \"" + email + "\","
                + "\"message\": \"" + mensagem + "\","
                + "\"token\": \"" + token + "\"}";

        try {
            var webResponse = webClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(jsonString)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // Usar block() para execução síncrona


            this.repository.save(new TokenEmail(null, email, token));
            System.out.println(webResponse);
        } catch (Exception e) {
            System.out.println("Erro ao acessar mensageria: " + e.getMessage());
        }
    }

    public void deleteTokenEmail(String email){
        var tkEmail = repository.findByEmail(email);
        if(tkEmail!=null){
            repository.delete(tkEmail);
        }
    }
}
