package dia.chapter2

// versão IntArray
fun exchange(a: IntArray, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

// versão Array<Int>
fun exchange(a: Array<Int>, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

fun selectionSort(a: IntArray, left: Int, right: Int) {
    for (i in left until right) {
        var min = i
        for (j in i+1..right) {
            if (a[min] > a[j]) min = j
        }
        exchange(a, min, i)
    }
}