package br.com.crud.Hospital.models.DTOs;

import br.com.crud.Hospital.models.Funcionarios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {
    public Long id;
    public String nome;
    public Integer matricula;
    public SetorDTO setor;

    public Funcionarios toEntity() {
        return Funcionarios.builder()
                .id(id)
                .nome(nome)
                .matricula(matricula)
                .setor(setor.toEntity())
                .build();
    }
}
