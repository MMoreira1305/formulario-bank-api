package com.example.formulario_api.controller;

import com.example.formulario_api.domain.dto.LeadDTO;
import com.example.formulario_api.services.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lead")
public class CadastroLeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LeadDTO leadDTO){
        return ResponseEntity.ok(leadService.cadastrar(leadDTO));
    }
}
