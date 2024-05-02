package complexity

/**
 * This function calculates the factorial of a given integer.
 *
 * The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
 * It is denoted by n!, and can be calculated as follows:
 * n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
 * The factorial function can be defined by the product
 * n! = n * (n-1)!, for n > 0
 * with the special case
 * 0! = 1
 *
 * @param n The integer for which the factorial is to be calculated.
 * @return The factorial of the given integer.
 *
 * Time complexity - O(n), where n is the given integer.
 * Space complexity - O(n), where n is the given integer.
 */
fun factorial(n: Int): Int {
    return if (n == 0) 1
    else n * factorial(n - 1)
}