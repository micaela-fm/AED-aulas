package dia.chapter1

// complexidade temporal O(2^n)
// complexidade espacial O(n)
fun fibonacciRecursive(n: Int) : Long {
    return if (n == 0 || n == 1) 1
    else fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
}

// complexidade temporal O(n)
// complexidade espacial O(n)
fun fibonacciMemorisation(n: Int) : Long {
    val array = LongArray(n+1)
    array[0] = 1
    array[1] = 1
    for (i in 2..n) {
        array[i] = array[i-1] + array[i-2]
    }
    return array[n]
}

// complexidade temporal O(n)
// complexidade espacial O(1)
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

// extra: implementar com complexidade temporal inferior
// usar matrizes
fun fibonacciMatrices(n: Int): Long = TODO()

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