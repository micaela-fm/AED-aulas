package trees

import kotlin.Pair

data class Node<E>(var item: E, var left: Node<E>? = null, var right: Node<E>? = null)

// árvore binária não BST
// percurso prefixo
fun <E> contains(root: Node<E>?, element: E): Boolean {
    if (root == null) return false
    else if (root.item == element) return true
    else return contains(root.left, element) || contains(root.right, element)
}


// Árvore BST
// percurso prefixo
// implementação recursiva
fun <E> containsRecursive(root: Node<E>?, element: E, cmp: Comparator<E>): Boolean {
    if (root == null) return false
    else {
        val c = cmp.compare(root.item, element)
        return if (c == 0)
            true
        else {
            if (c < 0)
                containsRecursive(root.right, element, cmp)
            else
                containsRecursive(root.left, element, cmp)
        }
    }
}

// Árvore BST
// percurso prefixo
// implementação iterativa
fun <E> containsIterative(root: Node<E>?, element: E, cmp: Comparator<E>): Boolean {
    var it = root
    while (it != null) {
        val c = cmp.compare(it.item, element)
        if (c == 0) {
            return true
        } else {
            if (c < 0) {
                it = it.right
            } else {
                it = it.left
            }
        }
    }
    return false
}

// percurso sufixo
fun <E> height(root: Node<E>?): Int {
    if (root == null)
        return -1
    val l = height(root.left)
    val r = height(root.right)
    return 1 + Math.max(l, r)
}

// percurso sufixo
fun <E> isComplete(root: Node<E>?): Boolean {
    return isCompleteAux(root) != -1 // -1 é usada para detetar o erro
}

// percurso sufixo
fun <E> isCompleteAux(root: Node<E>?): Int {
    if (root == null)
        return -1
    val l = isCompleteAux(root.left)
    val r = isCompleteAux(root.right)
    if (l == -1 || r == -1)
        return -1
    return if(l == r)
        1 + l
    else
        -1
}

data class Pair(var first: Int, var second: Int?)

// percurso infixo
fun kSmallest(root: Node<Int>?, k: Int): Int? {
    var pair = trees.Pair(k, null)
    kSmallestAux(root, pair)
    return pair.second
}

// percurso infixo
fun kSmallestAux(root: Node<Int>?, pair: trees.Pair) {
    if (root != null) {
        kSmallestAux(root.left, pair)
        pair.first--
        if (pair.first == 0)
            pair.second = root.item
        return
    }
    kSmallestAux(root?.right, pair)
}

// temos de devolver um nó porque, se a árvore estiver vazia, queremos retornar a raiz
// se tivéssemos uma classe Tree, já não seria necessário
fun add(root: Node<Int>?, element: Int): Node<Int>? {
    val new = Node(element)
    if (root == null)
        return new
    else {
        var current = root
        var previous: Node<Int>? = null
        while (current != null) {
            previous = current
            if (current.item < element)
                current = current.right
            else {
                if (current.item == element) // caso sejam igual, element já existe na árvore e não adiciona
                    return null
                current = current.left
            }
        }
        if (previous != null) {
            if (previous.item < element)
                previous.right = new
            else
                previous.left = new
        }
    }
    return root
}
