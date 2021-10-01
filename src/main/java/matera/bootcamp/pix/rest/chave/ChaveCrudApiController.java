package matera.bootcamp.pix.rest.chave;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Chave;
import matera.bootcamp.pix.service.chave.ChaveCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor

public class ChaveCrudApiController {
    private final ChaveCrudService chaveCrudService;

    @PostMapping("/api/v1/chave")

    public ResponseEntity<Chave> salvar(@RequestBody Chave chave,
                                        HttpServletRequest httpRequest,
                                        HttpServletResponse httpResponse) {

        var ehUmNovaChave = chave.getId() == null;
        var chaveSalvo = chaveCrudService.cadastrarChave(chave);

        return ResponseEntity
                .status(ehUmNovaChave ? HttpStatus.CREATED : HttpStatus.OK)
                .body(chaveSalvo);
    }

    @GetMapping("/api/v1/chave")
    public ResponseEntity<Page<Chave>> buscarPaginado(Pageable pageable) {

        var paginaChave = chaveCrudService.buscarPaginado(pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paginaChave);

    }
}