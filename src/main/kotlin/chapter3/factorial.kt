package chapter3

fun factorial(n: Int): Int {
    return if(n == 0) 1
    else n * factorial(n-1)
}

