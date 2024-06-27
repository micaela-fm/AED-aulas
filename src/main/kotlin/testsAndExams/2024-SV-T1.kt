package testsAndExams

// PARTE 1
/*
1. (7) (FOLHA 1)
Realize a função fun existsPair( array1: Array<Int>, array2: Array<Int>, value: Int ): Boolean
que, dado dois arrays array1 e array2, ordenados de modo estritamente crescente, e um inteiro value,
verifica se existe um par de inteiros (a, b) tal que a pertence ao array1 e b pertence ao array2 e a + b = value.
Caso exista, a função retorna true, caso contrário false.
Na implementação desta função não é permitida a utilização das funções de extensão do Kotlin.
 */

fun existsPair(array1: Array<Int>, array2: Array<Int>, value: Int): Boolean {
    var i = 0
    var j = array2.size - 1

    while (i < array1.size && j >= 0) {
        val sum = array1[i] + array2[j]
        if (sum == value) return true
        else if (sum < value) i++
        else j--
    }
    return false
}

/*
2. (7) (FOLHA 2) Realize a função
fun count( array: Array<Char> ): Int
que, dado um array ar de caracteres pertencentes ao conjunto {'a', 'b', 'c'},
retorna o número de sub-arrays de dimensão 3 que contêm os 3 caracteres distintos.
Por exemplo se array={'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'c'} então a função retorna 7.
Caso array={'a', 'b', 'c', 'c', 'b', 'b', 'a', 'c'} então a função retorna 2.
Na implementação desta função não é permitida a utilização das funções de extensão do Kotlin.
 */

fun count(array: Array<Char>): Int {
    val size = 3
    var counter = 0
    var countA = 0
    var countB = 0
    var countC = 0

    for (i in array.indices) {
        val current = array[i] // caracter que entra na janela deslizante

        when (current) {
            'a' -> countA++
            'b' -> countB++
            'c' -> countC++
        }

        if (i >= size) {
            val leavingChar = array[i - size] // caracter que sai da janela deslizante
            when (leavingChar) {
                'a' -> countA--
                'b' -> countB--
                'c' -> countC--
            }
        }

        if (countA == 1 && countB == 1 && countC == 1) {
            counter++
        }
    }
    return counter
}
