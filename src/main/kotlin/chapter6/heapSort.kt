package chapter6

import chapter2.exchange

/**
 * This function calculates the left child index of a node in a binary heap.
 *
 * @param i The index of the node.
 * @return The index of the left child.
 */
fun left(i: Int) = 2 * i + 1

/**
 * This function calculates the right child index of a node in a binary heap.
 *
 * @param i The index of the node.
 * @return The index of the right child.
 */
fun right(i: Int) = 2 * i + 2

/**
 * This function calculates the parent index of a node in a binary heap.
 *
 * @param i The index of the node.
 * @return The index of the parent.
 */
fun parent(i: Int) = (i - 1) / 2

/**
 * This function restores the max heap property at a given position.
 *
 * @param array The heap.
 * @param n The size of the heap.
 * @param pos The position at which to restore the heap property.
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

fun minHeapify(array: Array<Utente?>, size: Int, i: Int, cmp: (u1: Utente, u2: Utente) -> Int) {
    var pai = i
    while (pai < size) {
        val left = 2 * pai + 1
        val right = 2 * pai + 2

        if (left < size && cmp(array[left]!!, array[pai]!!) < 0) {
            pai = left
        }
        if (right < size && cmp(array[right]!!, array[pai]!!) < 0) {
            pai = right
        }

        if(pai!=i){
            val temp = array[pai]
            array[pai] = array[pai]
            array[pai] = temp
            minHeapify(array, size, pai, cmp)
        }
    }
}


/**
 * This function transforms a max heap into a sorted array.
 *
 * @param array The heap.
 * @param n The size of the heap.
 */
fun transform(array: Array<Int>, n: Int) {
    var size = n                            // size vai variando
    while (size > 0) {                      // troca o primeiro valor da árvore com o último ainda não fixado
        exchange(array, 0, --size)       // restaura a propriedade do heap a[i] <= a[pai]
        maxHeapify(array, size, 0)
    }
}

/**
 * This function builds a max heap from an unsorted array.
 *
 * @param array The array to be transformed into a heap.
 * @param n The size of the array.
 */
fun buildMaxHeap(array: Array<Int>, n: Int) {
    var pai = parent(n - 1)
    while (pai >= 0) {
        maxHeapify(array, n, pai)
        pai--
    }
}

/**
 * This function sorts an array using the Heap Sort algorithm.
 *
 * Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure.
 * It divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region.
 *
 * @param array The array of integers to be sorted.
 * @param n The size of the array.
 *
 * Time complexity - O(n log n)
 * Space complexity - O(1)
 */
fun heapSort(array: Array<Int>, n: Int) {
    buildMaxHeap(array, n)
    transform(array, n)
}
