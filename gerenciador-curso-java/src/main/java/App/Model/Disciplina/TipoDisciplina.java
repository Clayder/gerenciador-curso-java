
package App.Model.Disciplina;

public enum TipoDisciplina {
    PRATICA("pratica"), TEORICA("teorica");

    private String valor;
    
    private TipoDisciplina(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
