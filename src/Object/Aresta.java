package Object;

public class Aresta {

    private Vertice origem;
    private Vertice alvo;
    private Double peso;

    public Aresta(Vertice origem, Vertice alvo, Double peso) {
        this.origem = origem;
        this.alvo = alvo;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getAlvo() {
        return alvo;
    }

    public void setAlvo(Vertice alvo) {
        this.alvo = alvo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
