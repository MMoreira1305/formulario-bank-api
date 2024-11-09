package com.example.formulario_api.controller;

import com.example.formulario_api.services.LeadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "dadosLead", description = "Pega os dados do Lead cadastrado")
@RestController
@RequestMapping("/lead/obterDados")
public class GetLeadDataController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/{cpf}")
    public ResponseEntity<?> obterDados(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(leadService.dadosLead(cpf));
    }
}
