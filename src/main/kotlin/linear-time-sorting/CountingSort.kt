package `linear-time-sorting`

fun countingSort(arrayA: IntArray, min: Int, max: Int): IntArray {
    val arrayB = IntArray(arrayA.size)
    val arrayC = IntArray(max - min + 1)

    for (a in arrayA) {
        arrayC[a - min]++
    }

    for (i in 1..<arrayC.size) {
        arrayC[i] = arrayC[i] + arrayC[i - 1]
    }

    for (j in arrayB.size - 1 downTo 0) {
        arrayB[arrayC[arrayA[j - min]] - 1] = arrayA[j]
        arrayC[arrayA[j - min]]--
    }
    return arrayB
}
