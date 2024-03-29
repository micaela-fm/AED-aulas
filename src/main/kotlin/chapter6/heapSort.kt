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
    var largest = pos

    if (l < n && array[l] > array[largest]) {
        largest = l
    }
    if (r < n && array[r] > array[largest]) {
        largest = r
    }
    if (largest != pos) {
        exchange(array, largest, pos)
        maxHeapify(array, n, largest)
    }
}

/**
 * This function transforms a max heap into a sorted array.
 *
 * @param array The heap.
 * @param n The size of the heap.
 */
fun transform(array: Array<Int>, n: Int) {
    var size = n
    while (size > 0) {
        exchange(array, 0, --size)
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
    var parentIndex = parent(n - 1)
    while (parentIndex >= 0) {
        maxHeapify(array, n, parentIndex)
        parentIndex--
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