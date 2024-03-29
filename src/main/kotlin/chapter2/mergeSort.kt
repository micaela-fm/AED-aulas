package chapter2

/**
 * This function merges two sorted arrays into a single sorted array.
 *
 * @param a The original array.
 * @param left The left index from where to start the merge.
 * @param right The right index where to end the merge.
 * @param b The first sorted array to be merged.
 * @param c The second sorted array to be merged.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
fun merge(a: IntArray, left: Int, right: Int, b: IntArray, c: IntArray) {
    var iB = 0
    var iC = 0
    var iA = left

    while (iB < b.size) {
        a[iA++] = b[iB++]
    }
    while (iC < c.size) {
        a[iA++] = c[iC++]
    }
}

/**
 * This function merges two sorted subarrays of a single array.
 *
 * @param a The original array.
 * @param left The left index from where to start the merge.
 * @param mid The middle index where the first subarray ends and the second starts.
 * @param right The right index where to end the merge.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
fun merge(a: IntArray, left: Int, mid: Int, right: Int) {
    val b = IntArray(mid - left + 1)
    val c = IntArray(right - mid)

    for (i in b.indices) {
        b[i] = a[i + left]
    }
    for (i in c.indices) {
        c[i] = a[i + mid + 1]
    }

    merge(a, left, right, b, c)
}

/**
 * This function sorts an array using the Merge Sort algorithm.
 *
 * Merge Sort is a divide and conquer algorithm that divides the input array into two halves,
 * calls itself for the two halves, and then merges the two sorted halves.
 *
 * @param a The array of integers to be sorted.
 * @param left The left index from where to start the sorting.
 * @param right The right index where to end the sorting.
 *
 * Time complexity - O(n log n)
 * Space complexity - O(n)
 */
fun mergeSort(a: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(a, left, mid)
        mergeSort(a, mid + 1, right)
        merge(a, left, mid, right)
    }
}