package Main
import Core.Kruskal
import Core.exibirGrafo
import Object.*

fun main() {

    val grafo = loader()

    println("Kruskal ====== ")
    Kruskal(grafo)

}


fun loader():Grafo{

    println("Inicializando Grafo")

    val grafo = Grafo(arrayOf("A","B","C","D","E","F"))

    // A = 0; B = 1; C = 2; D = 3; E = 4; F = 5

/*  Teste 1
    grafo.addAresta("A","B", 4.0)
    grafo.addAresta("A","C", 3.0)
    grafo.addAresta("B","C", 1.0)
    grafo.addAresta("B","D", 2.0)
    grafo.addAresta("C","D", 4.0)
    grafo.addAresta("D","E", 2.0)
    grafo.addAresta("E","F", 6.0)
*/

    grafo.addAresta("A","B",1.0)
    grafo.addAresta("A","C",2.0)

    grafo.addAresta("B","C",3.0)

    grafo.addAresta("C","D",4.0)
    grafo.addAresta("C","E",5.0)
    grafo.addAresta("C","F",6.0)

    grafo.addAresta("D","C",4.0)
    grafo.addAresta("D","E",7.0)

    grafo.addAresta("E","D",7.0)
    grafo.addAresta("E","F",8.0)

//    grafo.addAresta("A","A",8.0)


    return grafo
}

