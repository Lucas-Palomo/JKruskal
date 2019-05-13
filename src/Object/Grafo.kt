package Object

import kotlin.collections.ArrayList

class Grafo(var vertices:Array<String>) {

    var aresta:ArrayList<Aresta> = ArrayList()

    fun addAresta(origem:String,destino:String,peso:Double){
        this.aresta.add(Aresta(origem,destino,peso))
    }

}

class Aresta (val origem:String,val destino:String,val peso:Double)
