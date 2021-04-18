package br.com.gustavo.ControleUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> CadUsuario(@RequestBody @Valid CadUsuarioRequest requisicao){

        Usuario usuario = requisicao.paraUsuario();
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ja existente no sistema!");
        }
        if(usuarioRepository.existsByCpf(usuario.getCpf())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "CPF ja existente no sistema!");
        }

        usuarioRepository.save(usuario);
        UsuarioResponse resposta = new UsuarioResponse(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario.toString());


    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponse> resposta = new ArrayList<>();
        for (Usuario usuario: usuarios){
            resposta.add(new UsuarioResponse(usuario));
        }
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponse> detalhar(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UsuarioResponse resposta = new UsuarioResponse(usuario.get());
        return  ResponseEntity.ok(resposta);
    }

}
