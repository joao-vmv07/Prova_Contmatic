package br.com.contmatic.model.telefone;

public enum TelefoneType {

    CELULAR("Celular", 9),
    FIXO("Fixo", 8);

    private String descricao;
    
    private int tamanho;

    public String getDescricao() {
        return descricao;
    }

    public int getTamanho() {
        return tamanho;
    }

    private TelefoneType(String descricao, int tamanho) {
        this.descricao = descricao;
        this.tamanho = tamanho;
    }
}
