package br.com.crud.Hospital.repositories;

import br.com.crud.Hospital.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    Optional<Setor> findBySetor(String setor);
}
