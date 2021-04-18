package br.com.gustavo.ControleEnderecos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadEnderecoRequest {

    @NotBlank
    @Column(nullable = false)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String cep;

    public CadEnderecoRequest(String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public Endereco paraEndereco(){
        return new Endereco(this.logradouro, this.numero, this.complemento, this.bairro, this.cidade, this.estado, this.cep);
    }
    }
