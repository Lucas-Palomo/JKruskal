package Object;

import java.util.*;

public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    private ArrayList<Grafo> componentes;

    public Grafo(){
        this.vertices = new ArrayList<Vertice>(0);
        this.arestas = new ArrayList<Aresta>(0);
    }
//    public Grafo(ArrayList<Vertice> vertices, ArrayList<Aresta> aresta){
//        this.vertices = vertices;
//        this.arestas = aresta;
//    }

    public Grafo(Vertice[] vertices){
        this.vertices = new ArrayList<Vertice>(0);
        this.arestas = new ArrayList<Aresta>(0);

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

    public void addAllArestas(ArrayList<Aresta> v1, ArrayList<Aresta> v2) {
        if(arestas.isEmpty()){
            this.arestas.addAll(v1);
        }else {
            for (Aresta aresta : this.arestas) {
                if (!existeAresta(v1, aresta) && !existeAresta(v2, aresta)) {
                    this.arestas.add(aresta);
                }
            }
        }
    }

    private Boolean existeAresta(ArrayList<Aresta> aresta, Aresta a){
        String idAresta = a.getOrigem().getIdVertice()+a.getAlvo().getIdVertice();
        for(Aresta tempAresta: aresta){
            String idTemp = new StringBuilder(tempAresta.getOrigem().getIdVertice()).append(tempAresta.getAlvo().getIdVertice()).reverse().toString();
            if(idTemp.equals(idAresta)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Grafo> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Grafo> componentes) {
        this.componentes = componentes;
    }


}
