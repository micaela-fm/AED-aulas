package dia.chapter1// sucessão a^n, com a > 0 e n >=0
// = 1, se n = 0
// = a*a^(n-1), se n > 0

// esta função tem recursividade do tipo "head recursion"
// funções cuja última instrução é a recursiva são tipo tipo "tail recursion"
// as "tail recursion" são sempre otimizáveis pelo compilador
fun powerRecursive(a: Int, n: Int): Int {
    return if (n == 0) 1
    else a * powerRecursive(a, n-1)
}

fun powerMemorisation(a: Int, n: Int): Int {
    if (n == 0) return 1
    val z = powerMemorisation(a, n/2)
    return if (n % 2 == 0) z * z
    else z * z * a
}

//fun powerMemorisation(a: Int, n: Int): Int {
//    if (n == 0) return 1
//    return if (n % 2 == 0) powerMemorisation(a, n/2) * powerMemorisation(a, n/2)
//    else powerMemorisation(a, n/2) * powerMemorisation(a, n/2) * a
//}

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