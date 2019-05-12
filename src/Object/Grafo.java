package Object;

import java.util.*;

public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private ArrayList<Grafo> componentes;

    public Grafo(Vertice[] vertices){
        this.vertices = new ArrayList<Vertice>(0);
        this.arestas = new ArrayList<Aresta>(0);
        this.componentes = new ArrayList<Grafo>(0);

        Collections.addAll(this.vertices, vertices);
        this.getArestas();

    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public void addVertice(Vertice vertice){
        this.vertices.add(vertice);
    }

    public void rmVertice(Vertice vertice){
        this.vertices.remove(vertice);
    }

    public ArrayList<Aresta> getArestas() {
        if(arestas.isEmpty()) {
            for (Vertice vertice : vertices) {
                this.arestas.addAll(vertice.getArestas());
//                for (Aresta aresta : vertice.getArestas()) {
//                    if (this.arestas.stream().noneMatch(o -> o.getAlvo() == aresta.getOrigem() && o.getOrigem() == aresta.getAlvo())) {
//                        this.arestas.add(aresta);
//                    }
//                }
            }
        }

        arestas.sort(Comparator.comparing(Aresta::getPeso));

        return this.arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }

    public void rmAresta(Aresta aresta){
        this.arestas.remove(aresta);
    }

    public ArrayList<Grafo> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Grafo> componentes) {
        this.componentes = componentes;
    }


}
