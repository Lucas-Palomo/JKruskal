package Core;
import Object.*;

import java.util.*;


public class Functions {

    public static void Kruskal(Grafo grafo){

        NavigableMap<String ,Grafo> arvores = new TreeMap<String, Grafo>();

        for (Vertice vertice: grafo.getVertices() ){
            vertice.setArestas(new ArrayList<Aresta>(0));
            Grafo treeGraph = new Grafo(new Vertice[]{vertice});
            arvores.put(vertice.getIdVertice(),treeGraph);
        }

        for (Aresta aresta : grafo.getArestas()) {
            Vertice origem = aresta.getOrigem();
            Vertice alvo = aresta.getAlvo();
            arvores.get(origem.getIdVertice()).addAresta(aresta);
            arvores.get(origem.getIdVertice()).addVertice(alvo);
        }

        ArrayList<String> keys = new ArrayList<>(arvores.keySet());


        System.out.println("Arvores Geradas: "+arvores.size());


        arvores.forEach((id, graph) -> {
            System.out.println("ID Arvore: "+id);
            graph.getVertices().forEach(vertice -> {
                System.out.println("\tVertices da Arvore: "+vertice.getIdVertice());
            });
            System.out.println(graph.getArestas().size());
            graph.getArestas().forEach(aresta -> {
                System.out.println("\t Arestas da Arvore: "+aresta.getOrigem().getIdVertice()+" - "+aresta.getAlvo().getIdVertice());
            });
        } );


    }

    private static Grafo MergeGraph(Grafo grafo1, Grafo grafo2){

        Grafo grafo = new Grafo();
        grafo.addAllArestas(grafo1.getArestas(),grafo2.getArestas());

        ArrayList<Vertice> vertices = new ArrayList<Vertice>();

        for (Vertice v: grafo1.getVertices()) {
            if (!existeVertice(vertices, v)) {
                grafo.addVertice(v);
                vertices.add(v);
            }
        }

        for (Vertice v: grafo2.getVertices()) {
            if (!existeVertice(vertices, v)) {
                grafo.addVertice(v);
                vertices.add(v);
            }
        }
//
//
//        for (Aresta a: grafo2.getArestas()) {
//            if (!existeAresta(arestas, a)) {
//
////                System.out.println(grafo.getVertices().contains(a.getOrigem()));
////                System.out.println(grafo.getVertices().contains(a.getAlvo()));
//
//                int indexOrigem = grafo.getVertices().indexOf(a.getOrigem());
//                int indexAlvo = grafo.getVertices().indexOf(a.getAlvo());
//
//                Vertice origem = grafo.getVertices().get(indexOrigem);
//                Vertice alvo = grafo.getVertices().get(indexAlvo);
//
//                grafo.addAresta(new Aresta(origem,alvo,a.getPeso()));
////                arestas.add(a);
//
//            }
//        }

        return grafo;
    }

    private static Boolean existeVertice(ArrayList<Vertice> vertices, Vertice v){
        for(Vertice tempVertice: vertices){
            if(tempVertice.equals(v)){
                return true;
            }
        }
        return false;
    }

//    private static Boolean existeAresta(ArrayList<Aresta> aresta, Aresta a){
//        String idAresta = a.getOrigem().getIdVertice()+a.getAlvo().getIdVertice();
//        for(Aresta tempAresta: aresta){
//            String idTemp = new StringBuilder(tempAresta.getOrigem().getIdVertice()).append(tempAresta.getAlvo().getIdVertice()).reverse().toString();
//            if(idTemp.equals(idAresta)){
//                return true;
//            }
//        }
//        return false;
//    }

    private static Boolean isCyclicUtil(Vertice origem, HashMap<Vertice,Boolean> visitado, Vertice alvo) {
        // Mark the current node as visited
        visitado.put(origem,true);
        Aresta i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Aresta> it = origem.getArestas().iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent ++++
            if (!visitado.get(i.getAlvo()))
            {
                if (isCyclicUtil(i.getAlvo(), visitado, origem))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle. ++
            else if (i.getAlvo() != alvo)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    public static Boolean isCyclic(ArrayList<Vertice> vertices) {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        HashMap<Vertice,Boolean> visitado = new HashMap<Vertice, Boolean>();
        for (Vertice vertice : vertices )
            visitado.put(vertice,false);

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (Vertice verticeAux: vertices)
            if (!visitado.get(verticeAux)) // Don't recur for u if already visited
                if (isCyclicUtil(verticeAux, visitado, null))
                    return true;

        return false;
    }

}
