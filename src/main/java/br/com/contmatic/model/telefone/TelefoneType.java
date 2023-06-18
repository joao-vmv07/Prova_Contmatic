package br.com.contmatic.model.telefone;

public enum TelefoneType {

    CELULAR("Celular"),
    FIXO("Fixo"),
    COMERCIAL("Comercial"); 

    private String descricao;
    
    public String getDescricao() {
     return descricao;
    }

    private TelefoneType(String descricao) {
        this.descricao = descricao;
    }
    
}
