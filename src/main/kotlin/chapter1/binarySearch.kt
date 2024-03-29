package chapter1

/**
 * This function performs a binary search in a sorted array in a recursive manner.
 *
 * @param a The sorted array of integers in which to search.
 * @param left The left index from where to start the search.
 * @param right The right index where to end the search.
 * @param elem The element to search for.
 * @return The index of the element if found, -1 otherwise.
 *
 * Time complexity - O(log n)
 * Space complexity - O(log n) due to recursive call stack
 */
fun binarySearchRecursive(a: IntArray, left: Int, right: Int, elem: Int): Int {
    if (right < left) return -1
    val mid = (left + right) / 2
    return if (a[mid] == elem) mid
    else {
        if (a[mid] > elem)
            binarySearchRecursive(a, left, mid - 1, elem)
        else binarySearchRecursive(a, mid + 1, right, elem)
    }
}

/**
 * This function performs a binary search in a sorted array in an iterative manner.
 *
 * @param a The sorted array of integers in which to search.
 * @param left The left index from where to start the search.
 * @param right The right index where to end the search.
 * @param elem The element to search for.
 * @return The index of the element if found, -1 otherwise.
 *
 * Time complexity - O(log n)
 * Space complexity - O(1)
 */
fun binarySearchIterative(a: IntArray, left: Int, right: Int, elem: Int): Int {
    var l = left
    var r = right
    while (l <= r) {
        val mid = (l + r) / 2
        if (a[mid] == elem) return mid // modify for upper/lower bound
        else {
            if (a[mid] < elem) l = mid + 1
            else r = mid - 1 // correct line for lower bound, change for upper bound
        }
    }
    return -1 // modify for upper/lower bound
}
