package week2Sorting
fun <T> Array<T>.exchange(i1: Int, i2: Int) { // <T> porque o algoritmo funciona para qualquer tipo
    val aux = this[i1]
    this[i1] = this[i2]
    this[i2] = aux
}

/**
 * Sort an subarray using the insertion sort algorithm. The algorithm is stable.
 * Methodology - in initial iteration, the first element is considered as sorted, and
 *      the remaning elements are considered as unsorted part.
 *      Fo each iteration take one value at a time from the unsorted part of the array
 *      and insert it in the correct position in the sorted part of the array.
 * Complexity in terms of time:
 *  worst case - O(n^2)
 *  best case - O(n)
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun <T> insertionSort(a:Array<T>, left:Int=0, right: Int=a.size-1, compare: (T, T) -> Int) {
    /* In each iteration:
     *   The left to j-1 is the sorted part of the array
     *   The j to right is the unsorted part of the array
     *   The element a[j] is inserted in the correct position in the sorted part of the array
     */
    for( j in left+1 .. right) {
        // Modify: Use left shift instead of exchange
        val key = a[j]
        for ( i in j downTo left+1) {
            if ( a[i] < a[i-1]) // para usar Array<T> (tipo genérico), precisamos de uma função de comparação
                a.exchange(i, i -1)
            else
                break
        }
    }
}

/*
fun insertionSort(a:Array<Int>, left:Int=0, right: Int=a.size-1,
                  compare: (Int,Int)-> Int) { TODO() }
                  */
fun sortCrescent( a: Array<Int> ) {
    insertionSort(a, 0, a.size-1, { i1, i2 -> i1.compareTo(i2) })

}
fun sortDeCrescent( a: Array<Int>) {
    insertionSort(a, 0, a.size-1, { i1, i2 -> i2.compareTo(i1) })
}


/**
 * Sort an subarray using the bubble sort algorithm. The algorithm is stable.
 * Methodology - for each iteration, transverse the array from the end to the
 *      beginning, compares the current element with the previous one, and if
 *      the current element is smaller, it exchanges the two elements.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun bubbleSort(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    for( i in left ..< right)
        for( j in right downTo i+1)
            if ( a[j] < a [j-1])
                a.exchange(j, j-1)
}

/**
 * Sort an subarray using the bubble sort algorithm optimized with a flag.
 * Methodology - When it detects that it is already sorted (not exist exchanges
 *               in the last iteration) it ends the sorting.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun bubbleSortFlag(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    var swap = true
    var i = left
    while (i < right && swap ) {
        swap = false
        for( j in right downTo i +1){
            if ( a[j] < a[j-1]) {
                swap = true
                a.exchange( j, j-1)
            }
        }
    }
}

/**
 * Sort an subarray using the selection sort algorithm. The algorithm not is stable.
 * Methodology - for each iteration SELECT the smallest
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun selectionSort(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    for( i in left ..< right) {
        var il = i
        for( j in i+1 .. right) {
            if (a[il] > a[j])
                il = j
        }
        a.exchange(i, il)
    }
}

/**
 * Sort an subarray using the merge sort algorithm. The algorithm is stable.
 * Methodology - Divide and conquer algorithm.
 *   It divides the array in two halves, sorts the two halves and
 *   then merges the two sorted halves.
 * Complexity in terms of time:
 *  worst case - n lg(n)
 *  best case - n lg(n)
 * Complexity in terms of memory: n + lg(n) ~ O(n)
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun mergeSort(a:Array<Int>, left: Int=0, right: Int = a.size-1 )  {
    if (left < right) { // caso contrário, o array tem apenas um elemento, pelo que já está ordenado
        val m = (left + right) ushr 1
        mergeSort(a, left, m)
        mergeSort(a, m+1, right)
        merge(a, left, m, right)
    }
}
/**
 * Take two sorted subarrays and merge them into a single sorted subarray.
 * First subarray is a[left .. m] and the second subarray is a[m+1..right]
 * Complexity in terms of time:
 *  worst case - O(n)
 *  best case - O(n)
 * Complexity in terms of memory: O(n)
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param middle - index where the first subarray ends (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun merge(a: Array<Int>, left: Int, middle: Int, right: Int) {
    val leftArray = a.copyOfRange(left, middle + 1) // left inclusive, m+1 exclusive
    val rightArray = a.copyOfRange(middle + 1, right + 1) // m+1 inclusive, right exclusive
    var i = left
    var leftIndex = 0
    var rightIndex = 0
    while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
        if (leftArray[leftIndex] >= rightArray[rightIndex]) {
            a[i++] = a[leftIndex++]
        } else {
            a[i++] = rightArray[rightIndex++]
        }
    }
    if (leftIndex < rightArray.size) leftArray.copyInto(a, i, leftIndex)
//    else rightArray.copyInto(a, i, rightIndex)
}