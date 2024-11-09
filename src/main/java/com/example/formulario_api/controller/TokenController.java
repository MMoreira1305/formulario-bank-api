package com.example.formulario_api.controller;

import com.example.formulario_api.services.EnvioEmailService;
import com.example.formulario_api.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EnvioEmailService envioEmailService;

    @GetMapping("/{email}")
    public ResponseEntity<?> verifyToken(@PathVariable String email){
        return ResponseEntity.ok(tokenService.getTokenByEmail(email));
    }

    @PutMapping("/confirm/{email}")
    public ResponseEntity<?> confirmToken(@PathVariable String email){
        tokenService.confirmToken(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send/{email}")
    public ResponseEntity<?> reenviaToken(@PathVariable String email){
        try {
            String token = this.tokenService.gerarToken();
            this.envioEmailService.enviarEmail(email, "Segue token de verificação de conta!", token);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Aconteceu algum erro ao tentar enviar email e criar token: " + e.getMessage());
        }
    }
}
