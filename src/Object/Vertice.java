package Object;

import java.util.ArrayList;

public class Vertice {

    private String idVertice;
    private ArrayList<Aresta> arestas;

    public Vertice(String idVertice) {
        this.idVertice = idVertice;
    }

    public String getIdVertice() {
        return idVertice;
    }

    public void setIdVertice(String idVertice) {
        this.idVertice = idVertice;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

}
