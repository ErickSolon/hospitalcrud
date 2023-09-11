package br.com.crud.Hospital.models;

import br.com.crud.Hospital.models.DTOs.SetorDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "setor")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "setor")
    private String setor;

    public SetorDTO toDTO() {
        return SetorDTO.builder()
                .id(id)
                .setor(setor)
                .build();
    }
}
