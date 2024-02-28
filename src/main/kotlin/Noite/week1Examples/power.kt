package week1Examples

import dia.aula1.powerRecursive

/**
 * Calculate the power of a number.
 * @param number the number to be raised
 * @param exponent the exponent
 * @return the number raised to the exponent
 */
/*
 *  Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(n)
 */
fun powerOfIterative( base: Int, exponent: Int ) : Int {
    var res = 1
    for (e in 1..exponent) {
        res *= base
    }
    return res
}

/**
 * Depth of the recursion:
 * Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(n)
 */
// devia ser tailrec, mas intellij não está a reconhecer
fun powerOfRecursive( base: Int, exponent: Int ) : Int {
    if (exponent == 0) return 1
    else return powerRecursive(base, exponent - 1) * base
}

/**
 * Calculate the power as follows:
 *   pow(b, 0) = 1
 *   pow(b, n) = pow(b, n/2)* pow(b, n/2) for n even
 *   pow(b, n) = b * pow(b, n/2)* pow(b, n/2) for n odd * Depth of the recursion:
 * Depth of the recursion: lg n
 * Complexity:
 *      in terms of time - O(n)
 *      in terms of extra space - O(lg n)
 */
fun powerOfN(base: Int, exponent: Int ) : Int {
    if ( exponent == 0) return 1
    else {
        if (exponent % 2 == 0)
            return powerOfN(base, exponent / 2) * powerRecursive(base, exponent / 2)
        else return powerOfN(base, exponent / 2) * powerOfN(base, exponent / 2) * base
    }
}

/**
 * Calculate the power as follows:
 *   pow(b, 0) = 1
 *   pow(b, n) = pow(b, n/2)* pow(b, n/2) for n even
 *   pow(b, n) = b * pow(b, n/2)* pow(b, n/2) for n odd * Depth of the recursion:
 * Depth of the recursion: lg n
 * Complexity:
 *      in terms of time - O(lg n)
 *      in terms of extra space - O(lg n)
 */
    // usando a variável auxiliar, não precisamos de chamar 2 vezes a função
    // o que reduz a complexidade temporal
    // mas não altera a espacial
fun powerOf( base: Int, exponent: Int ) : Int {
    if ( exponent == 0) return 1
    else {
        val aux = powerOf(base, exponent / 2)
        if (exponent % 2 == 0)
            return aux * aux
        else return aux * aux * base
    }
}