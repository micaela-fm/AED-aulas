package sortingAlgorithms

/**
 * This function sorts an array using the Insertion Sort algorithm.
 *
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time.
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 *
 * @param a The array of integers to be sorted.
 * @param l The left index from where to start the sorting.
 * @param r The right index where to end the sorting.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
fun insertionSort(a: IntArray, l: Int, r: Int) {
    for (i in l + 1..r) {
        val v = a[i]        // v holds the element to compare
        var j = i
        while (j > l && v < a[j - 1]) {
            a[j] = a[j - 1]   // places an element of the sorted array in the position of the element to compare
            j--
        }
        a[j] = v // places the element to compare in the position of the element of the sorted array
    }
}