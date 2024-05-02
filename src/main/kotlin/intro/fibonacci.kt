package intro

/**
 * This function calculates the Fibonacci number at a given position in a recursive manner.
 *
 * @param n The position in the Fibonacci sequence.
 * @return The Fibonacci number at the given position.
 *
 * Time complexity - O(2^n)
 * Space complexity - O(n)
 */
fun fibonacciRecursive(n: Int): Long {
    return if (n == 0 || n == 1) 1
    else fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

/**
 * This function calculates the Fibonacci number at a given position using memoization.
 *
 * @param n The position in the Fibonacci sequence.
 * @return The Fibonacci number at the given position.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
fun fibonacciMemorisation(n: Int): Long {
    val array = LongArray(n + 1)
    array[0] = 1
    array[1] = 1
    for (i in 2..n) {
        array[i] = array[i - 1] + array[i - 2]
    }
    return array[n]
}

/**
 * This function calculates the Fibonacci number at a given position using less space.
 *
 * @param n The position in the Fibonacci sequence.
 * @return The Fibonacci number at the given position.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
fun fibonacciLessSpace(n: Int): Long {
    if (n == 0 || n == 1) return 1

    var last = 1L
    var secondToLast = 1L
    for (i in 2..n) {
        val current = last + secondToLast
        secondToLast = last
        last = current
    }
    return last
}

/**
 * This function calculates the Fibonacci number at a given position using matrices.
 *
 * @param n The position in the Fibonacci sequence.
 * @return The Fibonacci number at the given position.
 *
 * Time complexity - To be implemented
 * Space complexity - To be implemented
 */
fun fibonacciMatrices(n: Int): Long = TODO()

/**
 * The main function to test the Fibonacci functions.
 */
fun main() {
    val n = 3
    var startTime = System.currentTimeMillis()
    println("FibonacciRecursive($n): ${fibonacciRecursive(n)}")
    print("Elapsed time: ${System.currentTimeMillis() - startTime} ms")
    println()

    startTime = System.currentTimeMillis()
    println("FibonacciMemorisation($n): ${fibonacciMemorisation(n)}")
    print("Elapsed time: ${System.currentTimeMillis() - startTime} ms")
    println()

    startTime = System.currentTimeMillis()
    println("FibonacciLessSpace($n): ${fibonacciLessSpace(n)}")
    print("Elapsed time: ${System.currentTimeMillis() - startTime} ms")
    println()
}