package dia.aula8
import dia.aula3.exchange

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
    var s = n // size vai variando
    while (s > 0) {
        exchange(array, 0, --s) // troca o primeiro valor da árvore com o último ainda não fixado
        maxHeapify(array, s, 0) // restaura a propriedade do heap a[i] <= a[pai]
    }
}