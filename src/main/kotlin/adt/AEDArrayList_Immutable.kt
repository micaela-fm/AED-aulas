package adt

class AEDArrayList_Immutable<E>: AEDList<E> {

    private var elements: Array<E>

    constructor(array: Array<E>) {
        elements = array
    }

    override val size: Int
        get() = elements.size

    operator override fun get(i: Int): E {
        return elements[i]
    }

    override fun contains(element: E): Boolean {
        return elements.contains(element)
    }

    override fun isEmpty(): Boolean = size == 0
}
