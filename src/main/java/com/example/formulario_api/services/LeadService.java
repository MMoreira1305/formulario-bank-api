package com.example.formulario_api.services;

import com.example.formulario_api.domain.dto.LeadDTO;
import com.example.formulario_api.domain.model.Lead;
import com.example.formulario_api.domain.model.TokenEmail;
import com.example.formulario_api.repository.LeadRepository;
import com.example.formulario_api.repository.TokenEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private EnvioEmailService envioEmail;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TokenEmailRepository tokenEmailRepository;

    public String cadastrar(LeadDTO lead){
        String token = this.tokenService.gerarToken();
        // Verificando se já existe token enviado, se sim, deletar
        this.leadRepository.save(new Lead(lead));
        this.envioEmail.enviarEmail(lead.email(), "Segue token de verificação de conta!", token);
        return token;
    }

    public List<LeadDTO> dadosLead(String cpf){
        List<Lead> leads = leadRepository.findByCpf(cpf);
        if (leads == null || leads.isEmpty()) {
            return Collections.emptyList();
        }

        return leads.stream()
                .map(LeadDTO::fromLead)
                .collect(Collectors.toList());
    }
}
