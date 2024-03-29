package chapter2

/**
 * This function sorts an array using the Bubble Sort algorithm.
 *
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until the list is sorted.
 *
 * @param array The array of integers to be sorted.
 * @param left The left index from where to start the sorting.
 * @param right The right index where to end the sorting.
 *
 * Time complexity - O(n^2) for both best and worst cases
 * Space complexity - O(1)
 */
fun bubbleSort(array: IntArray, left: Int, right: Int) {
    for (i in left until right) {
        for (j in right downTo i + 1) {
            if (array[j] < array[j - 1]) {
                exchange(array, i, j)
            }
        }
    }
}