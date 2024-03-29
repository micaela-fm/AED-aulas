package chapter1

/**
 * This function calculates the power of a number in a recursive manner.
 *
 * @param a The base number.
 * @param n The exponent.
 * @return The result of a^n.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
fun powerRecursive(a: Int, n: Int): Int {
    return if (n == 0) 1
    else a * powerRecursive(a, n - 1)
}

/**
 * This function calculates the power of a number using memoization.
 *
 * @param a The base number.
 * @param n The exponent.
 * @return The result of a^n.
 *
 * Time complexity - O(log n)
 * Space complexity - O(log n)
 */
fun powerMemorisation(a: Int, n: Int): Int {
    if (n == 0) return 1
    val z = powerMemorisation(a, n / 2)
    return if (n % 2 == 0) z * z
    else z * z * a
}

/**
 * The main function to test the power functions.
 */
fun main() {
    val a = 11
    val n = 1234

    var startTime = System.currentTimeMillis()
    println("powerRecursive: $a^$n = ${powerMemorisation(a, n)}")
    println("Elapsed time: ${System.currentTimeMillis() - startTime} ms")
    println()

    startTime = System.currentTimeMillis()
    println("powerMemorisation: $a^$n = ${powerRecursive(a, n)}")
    println("Elapsed time: ${System.currentTimeMillis() - startTime} ms")
}