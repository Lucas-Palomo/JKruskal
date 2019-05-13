package Core
import Object.*
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

fun exibirGrafo(arestas:ArrayList<Aresta>){
    arestas.forEachIndexed { index, aresta ->
        println("Aresta ${index} | origem ${aresta.origem} | destino ${aresta.destino} | peso ${aresta.peso}")
    }
    println("\nCusto => ${getCusto(arestas)}")
}

fun Kruskal(grafo: Grafo){

    val mst = ArrayList<Aresta>()
    val fifo = ordenarAresta(grafo.aresta)
    val tree:Array<String> = grafo.vertices
    var index = 0

    while (index < grafo.vertices.size - 1 ){

        val aresta : Aresta = fifo.remove()

        val aresta_origem:Int = insereAresta(tree,aresta.origem)
        val aresta_destino:Int = insereAresta(tree,aresta.destino)

        if(aresta_origem != aresta_destino){
            mst.add(aresta)
            index++
            mergeTree(tree, tree.get(aresta_origem), tree.get(aresta_destino))
        }

    }

    exibirGrafo(mst)
}

fun insereAresta(tree: Array<String>, vertice: String): Int {
    return if (tree.indexOf(vertice) != getPos(vertice)) insereAresta(tree, tree.get(getPos(vertice))) else getPos(vertice)
}

fun mergeTree(tree: Array<String>, origem: String, destino: String) {
    // Adiciona na arvore destino a arvore origem
    val aresta_origem = insereAresta(tree, origem)
    val aresta_destino = insereAresta(tree, destino)
    tree[aresta_destino] = tree.get(aresta_origem)
}

fun getPos(id:String):Int{
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return alphabet.indexOf(id)
}

fun ordenarAresta(arestas: ArrayList<Aresta>):PriorityQueue<Aresta>{

    val fifo = PriorityQueue<Aresta>(arestas.size, Comparator.comparingDouble { o -> o.peso })

    arestas.forEach { aresta ->
        fifo.add(aresta)
    }

    return fifo
}

fun getCusto(arestas: ArrayList<Aresta>):Double{
    return arestas.stream().mapToDouble { o -> o.peso }.sum()
}
