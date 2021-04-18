package br.com.gustavo.ControleUsuarios;
import java.time.LocalDate;

public class UsuarioResponse {


    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    public UsuarioResponse(Usuario usuario) {

        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
