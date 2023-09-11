package br.com.crud.Hospital.Controllers;

import br.com.crud.Hospital.Exceptions.FuncionarioNotFoundException;
import br.com.crud.Hospital.Services.HospitalService;
import br.com.crud.Hospital.models.DTOs.FuncionariosDTO;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService service;

    @PostMapping
    public ResponseEntity<FuncionariosDTO> save(@RequestBody FuncionariosDTO funcionariosDTO) {
        return ResponseEntity.ok(service.save(funcionariosDTO));
    }

    @GetMapping
    public ResponseEntity<List<FuncionariosDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<FuncionariosDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<FuncionariosDTO> updateById(@PathVariable Long id, @RequestBody FuncionariosDTO funcionariosDTO) throws FuncionarioNotFoundException {
        return ResponseEntity.ok(service.updateById(id, funcionariosDTO));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
