package intro

/**
 * A data class representing a Triple of integers.
 *
 * @property left The left index of the maximal subarray.
 * @property sum The sum of the maximal subarray.
 * @property right The right index of the maximal subarray.
 */
data class Triple(val left: Int, val sum: Int, val right: Int)

/**
 * This function calculates the maximal subarray within a given array.
 *
 * We start by looking at the best subarray that starts at index 0, the best that starts at index 1, etc.
 * Then, we compare the various subarrays obtained and choose the best one.
 *
 * @param a The array of integers in which to find the maximal subarray.
 * @param l The left index from where to start looking for the maximal subarray.
 * @param r The right index where to end looking for the maximal subarray.
 * @return A Triple containing the left index, sum, and right index of the maximal subarray.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
fun maximalSubarray(a: IntArray, l: Int, r: Int): Triple {
    // best triple so far
    var bestLeft = l
    var bestRight = l - 1   // we start with an empty subarray
    var bestSum = 0
    var actualSum = 0

    for (i in l..r) {
        actualSum = 0
        for (j in i..r) {
            actualSum += a[j]
            if (actualSum >= bestSum) {
                // new best triple
                bestSum = actualSum
                bestLeft = i
                bestRight = j
            }
        }
    }
    return Triple(bestLeft, bestSum, bestRight)
}