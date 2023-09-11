package br.com.crud.Hospital.models;

import br.com.crud.Hospital.models.DTOs.FuncionariosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
    @Column(name = "matricula", unique = true)
    private Integer matricula;
    @OneToOne
    @MapsId
    private Setor setor;
    public FuncionariosDTO toDTO() {
        return FuncionariosDTO.builder()
                .id(id)
                .nome(nome)
                .matricula(matricula)
                .setor(setor.toDTO())
                .build();
    }
}
