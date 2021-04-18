package br.com.gustavo.Validacao;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDeValidacaoResponse>> handle(MethodArgumentNotValidException validacao){
        List<ErroDeValidacaoResponse> listaDeErros = new ArrayList<>();

        List<FieldError> fieldErrors = validacao.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            ErroDeValidacaoResponse erro = new ErroDeValidacaoResponse(fieldError.getDefaultMessage(), fieldError.getField());
            listaDeErros.add(erro);
        });

        return ResponseEntity.badRequest().body(listaDeErros);
    }

}
