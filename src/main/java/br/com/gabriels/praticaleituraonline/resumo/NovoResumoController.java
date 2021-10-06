package br.com.gabriels.praticaleituraonline.resumo;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NovoResumoController {

    private final ResumoRepository resumoRepository;

    public NovoResumoController(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    @PostMapping("/resumos")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid NovoResumoRequest novoResumoRequest) {
        Resumo resumo = resumoRepository.save(novoResumoRequest.toModel());
        return ResponseEntity.ok(resumo.getId());
    }

}
