package testsAndExams

class Node<E>(element: E?) {
    var item: E? = element
    var next: Node<E>
    var previous: Node<E>

    init {
        next = this
        previous = this
    }
}

/*
3. (3.5)(FOLHA5) Realize a função fun segment( v: IntArray, l: Int, r: Int, element: Int )
que segmenta o sub-array (v, l, r) em relação a element, isto é, no sub-array (v, l, r),
os elementos menores que element terão de ocorrer antes de todos os elementos maiores do que element.
Note que element pode não ocorrer no sub-array (v, l, r).
*/

fun segment(v: IntArray, l: Int, r: Int, element: Int) {
    if (l >= r) return

    var i = l
    var j = r

    while (i <= j) {
        if (v[i] >= element) {
            if (v[j] < element) {
                val aux = v[i]
                v[i] = v[j]
                v[j] = aux
            }
            j--
        }
        i++
    }
}

fun reverse(list: Node<Int>) {
    var current = list
    var previous = current.previous
    var next = current.next

    do {
        val aux = previous
        previous = next
        next = aux
        current = previous
    } while (current != list)
}

fun countBetween(root: trees.Node<Int>?, min: Int, max: Int): Int {
    var counter = 0

    if (root == null)
        return counter

    if (root.item < min)
        counter += countBetween(root.right, min, max)
    if (root.item > max)
        counter += countBetween(root.left, min, max)
    else {
        counter++
        counter += countBetween(root.left, min, max)
        counter += countBetween(root.right, min, max)
    }
    return counter
}

fun main() {
    println("hello world")
}


