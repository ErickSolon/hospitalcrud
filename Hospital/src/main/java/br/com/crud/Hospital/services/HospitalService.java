package br.com.crud.Hospital.services;

import br.com.crud.Hospital.exceptions.FuncionarioNotFoundException;
import br.com.crud.Hospital.models.DTOs.FuncionariosDTO;
import br.com.crud.Hospital.models.DTOs.SetorDTO;
import br.com.crud.Hospital.models.Funcionarios;
import br.com.crud.Hospital.models.Setor;
import br.com.crud.Hospital.repositories.FuncionariosRepository;
import br.com.crud.Hospital.repositories.SetorRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final FuncionariosRepository repository;
    private final SetorRepository setorRepository;

    public FuncionariosDTO save(FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionario = funcionariosDTO.toEntity();
        SetorDTO setorDTO = funcionariosDTO.setor;
        Setor setor = setorRepository.findBySetor(setorDTO.setor)
                .orElseGet(() -> {
                    Setor novoSetor = Setor.builder()
                            .setor(setorDTO.setor)
                            .build();
                    return setorRepository.save(novoSetor);
                });
        funcionario.setSetor(setor);
        Funcionarios funcionarioSalvo = repository.save(funcionario);
        return funcionarioSalvo.toDTO();
    }

    public List<FuncionariosDTO> findAll() {
        return repository.findAll().stream().map(Funcionarios::toDTO).collect(Collectors.toList());
    }

    @SneakyThrows
    public FuncionariosDTO findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException()).toDTO();
    }

    public FuncionariosDTO updateById(Long id, FuncionariosDTO funcionariosDTO) throws FuncionarioNotFoundException {
        Funcionarios funcionario = repository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException());
        Setor setor = funcionario.getSetor();
        String novoNomeSetor = funcionariosDTO.setor.setor;
        if (!setor.getSetor().equals(novoNomeSetor)) {
            setor.setSetor(novoNomeSetor);
            setorRepository.save(setor);
        }
        funcionario.setNome(funcionariosDTO.nome);
        funcionario.setMatricula(funcionariosDTO.matricula);
        Funcionarios funcionarioSalvo = repository.save(funcionario);
        return funcionarioSalvo.toDTO();
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
        setorRepository.deleteById(id);
    }
}
