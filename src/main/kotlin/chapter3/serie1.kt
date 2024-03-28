fun xpto(x: Int, n: Int): Int {
    return if (n == 0) 1
    else if (n % 2 == 0) xpto(x, n / 2) * xpto(x, n / 2)
    else xpto(x, n / 2) * xpto(x, n / 2) * x
}

fun xpto2(x: Int, n: Int): Int {
    if (n == 0) return 1
    val y = xpto2(x, n/2)
    return if (n % 2 == 0) y * y
    else y * y * x
}

fun main() {
    xpto(1, 2)
    xpto2(1, 2)
}