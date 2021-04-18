package br.com.gustavo.ControleUsuarios;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class CadUsuarioRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @CPF
    private String cpf;
    @NotNull   @PastOrPresent
    private LocalDate dataNascimento;

    public CadUsuarioRequest(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }


    public Usuario paraUsuario(){
        return new Usuario(this.nome, this.email, this.cpf, this.dataNascimento);
    }

}
