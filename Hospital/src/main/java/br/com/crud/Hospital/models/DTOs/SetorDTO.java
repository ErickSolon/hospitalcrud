package br.com.crud.Hospital.models.DTOs;

import br.com.crud.Hospital.models.Setor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SetorDTO {
    public Long id;
    public String setor;
    public Setor toEntity() {
        return Setor.builder()
                .id(id)
                .setor(setor)
                .build();
    }
}
