package com.example.formulario_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Properties;

@Service
public class EnvioEmailService {

    @Autowired
    private Properties props;

    private final String url = props.getProperty("API_MENSAGERIA_URL");

    private final WebClient webClient = WebClient.builder()
            .baseUrl(url)
            .build();

    public void enviarEmail(String email, String mensagem, String token) throws Exception {
        String jsonString = "{\"email\": \""+ email + "\","
                            + "{\"message\": \""+ mensagem + "\","
                            + "{\"token\": \""+ token + "\",";

        try {
            var webResponse = webClient.post()
                    .uri("send/sms")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(mensagem)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // Usar block() para execução síncrona

            System.out.println(webResponse);
        }catch (Exception e){
            throw new Exception("Erro ao tentar se comunicar com mensageria: " + e.getMessage());
        }

    }
}
