package adt

interface AEDList<E>{
    val size: Int
    fun isEmpty(): Boolean
    fun get(i: Int): E
    fun contains(element: E): Boolean
    // definir as operações
}
