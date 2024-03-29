package chapter2

/**
 * This function exchanges the elements at two positions in an integer array.
 *
 * @param a The array in which the elements are to be exchanged.
 * @param i The index of the first element.
 * @param j The index of the second element.
 */
fun exchange(a: IntArray, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

/**
 * This function exchanges the elements at two positions in an array of any type.
 *
 * @param a The array in which the elements are to be exchanged.
 * @param i The index of the first element.
 * @param j The index of the second element.
 */
fun <T> exchange(a: Array<T>, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

/**
 * This function sorts an array using the Selection Sort algorithm.
 *
 * Selection Sort is a simple sorting algorithm that maintains a sorted subarray and an unsorted subarray in a given array.
 * The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element becomes a part of the sorted array.
 * This process continues moving unsorted array boundary by one element to the right.
 *
 * @param a The array of integers to be sorted.
 * @param left The left index from where to start the sorting.
 * @param right The right index where to end the sorting.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
fun selectionSort(a: IntArray, left: Int, right: Int) {
    for (i in left until right) {
        var min = i
        for (j in i + 1..right) {
            if (a[min] > a[j]) min = j
        }
        exchange(a, min, i)
    }
}