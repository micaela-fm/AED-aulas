package dia.aula2

data class Triple(val left: Int, val sum: Int, val right: Int)

/*
Complexidade temporal - O(n^2)
Complexidade espacial - O(1)
 */
/*
começamos por ver o melhor subarray que começa no índice 0, o melhor que começa no índice 1, etc
depois comparamos os vários subarrays obtidos e escolhemos o melhor
 */
// l - índice mais à esquerda
// r - índice mais à direita
fun maximalSubarray(a: IntArray, l: Int, r: Int): Triple {
    // melhor triplo até ao momento
    var bestLeft = l
    var bestRight = l - 1   // começamos com um subarray vazio
    var bestSum = 0
    var actualSum = 0

    for (i in l..r) {
        actualSum = 0
        for (j in i..r) {
            actualSum += a[j]
            if (actualSum >= bestSum) {
                // novo melhor triplo
                bestSum = actualSum
                bestLeft = i
                bestRight = j
            }
        }
    }
    return Triple(bestLeft, bestSum, bestRight)
}