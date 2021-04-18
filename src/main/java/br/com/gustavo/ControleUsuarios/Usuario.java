package br.com.gustavo.ControleUsuarios;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable = false)
    private String nome;

    @NotBlank @Email @Column(nullable = false, unique = true)
    private String email;

    @NotBlank @CPF @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull @PastOrPresent @Column(nullable = false)
    private LocalDate dataNascimento;

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Deprecated
    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    @Override
    public String toString(){
        return  "Usuario{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", dataNascimento =" + dataNascimento +
                '}';
    }

}
