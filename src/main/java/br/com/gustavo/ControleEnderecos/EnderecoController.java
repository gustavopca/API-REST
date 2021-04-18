package br.com.gustavo.ControleEnderecos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;


    @PostMapping
    public ResponseEntity<String> CadEndereco(@RequestBody @Valid CadEnderecoRequest requisicao){
        Endereco endereco = requisicao.paraEndereco();
        enderecoRepository.save(endereco);
        EnderecoResponse resposta = new EnderecoResponse(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco.toString());

    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> listar(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoResponse> resposta = new ArrayList<>();
        for (Endereco endereco: enderecos){
            resposta.add(new EnderecoResponse(endereco));
        }
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    ResponseEntity<EnderecoResponse> detalhar(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        EnderecoResponse resposta = new EnderecoResponse(endereco.get());
        return  ResponseEntity.ok(resposta);
    }

}
