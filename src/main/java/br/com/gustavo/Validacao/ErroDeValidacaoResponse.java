package br.com.gustavo.Validacao;

public class ErroDeValidacaoResponse {
    private String mensagem;
    private String campo;

    public ErroDeValidacaoResponse(String mensagem, String campo) {
        this.mensagem = mensagem;
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCampo() {
        return campo;
    }
}
