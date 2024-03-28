package chapter6
import chapter2.exchange

fun left(i: Int) = 2 * i + 1

fun right(i: Int) = 2 * i + 2

fun parent(i: Int) = (i - 2) / 2

/*
 * @param array
 * @param n dimensão do array
 * @param pos posição a restaurar a propriedade do heap
 * @return
 */
fun maxHeapify(array: Array<Int>, n: Int, pos: Int) {
    val l = left(pos)
    val r = right(pos)
    var pai = pos

    if (l < n && array[l] > array[pai]) {
        pai = l
    }
    if (r < n && array[r] > array[pai]) {
        pai = r
    }
    if (pai != pos) {
        exchange(array, pai, pos)
        maxHeapify(array, n, pai)
    }
}

fun transform(array: Array<Int>, n: Int) {
    var size = n // size vai variando
    while (size > 0) {
        exchange(array, 0, --size) // troca o primeiro valor da árvore com o último ainda não fixado
        maxHeapify(array, size, 0) // restaura a propriedade do heap a[i] <= a[pai]
    }
}

fun buildMaxHeap(array: Array<Int>, n: Int) {
    var pai = parent(n - 1)
    while (pai >= 0) {
        maxHeapify(array, n, pai)
        pai--
    }
}

fun heapSort(array: Array<Int>, n: Int) {
    buildMaxHeap(array, n)
    transform(array, n)
}