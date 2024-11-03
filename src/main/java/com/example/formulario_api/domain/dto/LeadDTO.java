package com.example.formulario_api.domain.dto;

import com.example.formulario_api.domain.model.Lead;
import jakarta.validation.constraints.NotNull;

public record LeadDTO(@NotNull String nome,
                      @NotNull String cpf,
                      @NotNull String email,
                      @NotNull String telefone,
                      @NotNull Float valorFinanciamento,
                      @NotNull Integer prazo,
                      @NotNull Float rendaMensal,
                      @NotNull Float patrimonio) {

    public static LeadDTO fromLead(Lead lead) {
        return new LeadDTO(lead.getNome(), lead.getCpf(), lead.getEmail(),
                lead.getTelefone(), lead.getValorFinanciamento(), lead.getPrazo(),
                lead.getRendaMensal(), lead.getPatrimonio());
    }
}
