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

            System.out.println(origem.getIdVertice() + "-" + alvo.getIdVertice());


            arvores.get(origem.getIdVertice()).addAresta(aresta);
            arvores.get(origem.getIdVertice()).addVertice(alvo);


        }


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

    public static Boolean isCyclicUtil(Vertice origem, HashMap<Vertice,Boolean> visitado, Vertice alvo)
    {
        // Mark the current node as visited
        visitado.put(origem,true);
        Aresta i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Aresta> it = origem.getArestas().iterator();
        while (it.hasNext())
        {
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
    public static Boolean isCyclic(ArrayList<Vertice> vertices)
    {
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
