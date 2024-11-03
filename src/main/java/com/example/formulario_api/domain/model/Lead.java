package com.example.formulario_api.domain.model;

import com.example.formulario_api.domain.dto.LeadDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lead_consumer")
@Entity(name = "lead_consumer")
public class Lead {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Float valorFinanciamento;
    private Integer prazo;
    private Float rendaMensal;
    private Float patrimonio;

    public Lead(LeadDTO leadDTO){
        this.nome = leadDTO.nome();
        this.cpf = leadDTO.cpf();
        this.email = leadDTO.email();
        this.telefone = leadDTO.telefone();
        this.valorFinanciamento = leadDTO.valorFinanciamento();
        this.prazo = leadDTO.prazo();
        this.rendaMensal = leadDTO.rendaMensal();
        this.patrimonio = leadDTO.patrimonio();
    }
}
