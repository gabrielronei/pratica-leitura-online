package br.com.gabriels.praticaleituraonline.resumo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListaResumoController {

    private final ResumoRepository resumoRepository;

    public ListaResumoController(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    @GetMapping("/resumos")
    public ResponseEntity listar() {
        List<ResumoOutputDTO> resumos = resumoRepository.findAll().stream()
                .map(ResumoOutputDTO::new).toList();

        return ResponseEntity.ok(resumos);
    }
}
