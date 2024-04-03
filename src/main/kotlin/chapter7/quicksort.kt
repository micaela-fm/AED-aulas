package chapter7

import chapter2.exchange
import java.util.*

/**
 * This function partitions an array for the QuickSort algorithm.
 *
 * It chooses a pivot element from the array and partitions the other elements into two sub-arrays,
 * according to whether they are less than or greater than the pivot. The pivot element is then in its final position.
 *
 * @param array The array to be partitioned.
 * @param left The left index from where to start the partitioning.
 * @param right The right index where to end the partitioning.
 * @return The index of the pivot element.
 */
fun partition(array: Array<Int>, left: Int, right: Int): Int {
    var i = left - 1 // para fazer ++i
    var j = right
    val pivot = array[right]

    while (true) {
        while (i < right && array[++i] < pivot); // estes whiles sem corpo precisam de ;
        while (j > left && array[--j] > pivot);  // para que a instrução seja executada

        if (i >= j) break

        exchange(array, i, j)
    }
    exchange(array, i, right)
    return i
}

/**
 * This function sorts an array using the QuickSort algorithm.
 *
 * QuickSort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array
 * and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
 * The sub-arrays are then recursively sorted.
 *
 * @param array The array of integers to be sorted.
 * @param left The left index from where to start the sorting.
 * @param right The right index where to end the sorting.
 *
 * Time complexity - O(n log n) in the average case, O(n^2) in the worst case.
 * Space complexity - O(log n)
 */
fun quickSortRecursive(array: Array<Int>, left: Int, right: Int) {
    val i = partition(array, left, right)

    if (left < right) {
        quickSortRecursive(array, left, i - 1)
        quickSortRecursive(array, i + 1, right)
    }
}


/**
 * This function sorts an array using the iterative QuickSort algorithm.
 *
 * QuickSort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array
 * and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
 * The sub-arrays are then iteratively sorted using a stack to avoid recursion.
 *
 * @param array The array of integers to be sorted.
 * @param left The left index from where to start the sorting.
 * @param right The right index where to end the sorting.
 *
 * Time complexity - O(n log n) in the average case, O(n^2) in the worst case.
 * Space complexity - O(n) due to the use of a stack for storing left and right indices.
 */
/* Em espaço, é
 * O(log n) com ifs
 * O(n) sem ifs
 */
fun quicksortIterative(array: Array<Int>, left: Int, right: Int) {
    val stack = Stack<Int>()
    stack.push(left)
    stack.push(right)
    while (stack.isNotEmpty()) {
        var r = stack.pop()     // right
        var l = stack.pop()     // left

        if (r <= l) continue    // salta para a próxima iteração sem fazer o resto da iteração atual

        var i = partition(array, l, r)
        if (l - 1 >= r - 1) {
            // elementos da partição esquerda
            stack.push(l)
            stack.push(i - 1)
            // elementos da partição direita
            stack.push(i + 1)
            stack.push(r)
        }
        if (l - 1 < r - 1) {
        // elementos da partição direita
            stack.push(i + 1)
        stack.push(r)
        // elementos da partição esquerda
        stack.push(l)
        stack.push(i - 1)
            }
    }
}
