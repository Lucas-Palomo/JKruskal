package Main
import Object.*
import Core.Functions

fun main() {

    val grafo = loader()

    println("Kruska ====== ")

    Functions.Kruskal(grafo)

//    println(Functions.isCyclic(grafo.vertices))

}


fun loader():Grafo{

    println("Inicializando Grafo")


    val a = Vertice("A")
    val b = Vertice("B")
    val c = Vertice("C")
    val d = Vertice("D")
    val e = Vertice("E")
    val f = Vertice("F")

    a.arestas = arrayListOf(
        Aresta(a,b,1.0),
        Aresta(a,c,2.0)
    )

    b.arestas = arrayListOf(
        Aresta(b, a,1.0),
        Aresta(b, c,3.0)
    )

    c.arestas = arrayListOf(
        Aresta(c, a,2.0),
        Aresta(c, b,3.0),
        Aresta(c, d,4.0),
        Aresta(c, f,6.0),
        Aresta(c, e,5.0)
    )

    d.arestas = arrayListOf(
        Aresta(d, c,4.0),
        Aresta(d, e,7.0)
    )

    e.arestas = arrayListOf(
        Aresta(e, d,7.0),
        Aresta(e, c,5.0),
        Aresta(e, f,8.0)
    )

    f.arestas = arrayListOf(
        Aresta(f, c,6.0),
        Aresta(f, e,8.0)
    )

    return Grafo(arrayOf(a,b,c,d,e,f))

}

