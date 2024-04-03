package chapter7

import chapter2.exchange

fun partition(array: Array<Int>, left: Int, right: Int): Int {
    var i = left - 1 // para fazer ++i
    var j = right
    val pivot = array[right]

    while (true) {
        while (i < right && array[++i] < pivot); // estes whiles sem corpo precisam de ;
        while (j > left && array[--j] > pivot);  // para que a instrução seja executada

        if (i >= j)
            break

        exchange(array, i, j)
    }
    exchange(array, i, right)
    return i
}

fun quickSort(array: Array<Int>, left: Int, right: Int) {
    val i = partition(array, left, right)

    if (left < right) {
        quickSort(array, left, i - 1)
        quickSort(array, i + 1, right)
    }
}

