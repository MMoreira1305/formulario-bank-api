package com.example.formulario_api.services;

import com.example.formulario_api.domain.dto.LeadDTO;
import com.example.formulario_api.domain.model.Lead;
import com.example.formulario_api.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private EnvioEmailService envioEmail;

    public String cadastrar(LeadDTO lead){
        String token = this.gerarToken();
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

    public String gerarToken(){
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
