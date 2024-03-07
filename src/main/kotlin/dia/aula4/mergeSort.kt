package dia.aula4

fun merge(a: IntArray, left: Int, right: Int, b: IntArray, c: IntArray) {
    var iB = 0
    var iC = 0
    var iA = left

    while (iB < b.size && iC < c.size) {
        if (b[iB] <= c[iC]) {
            a[iA] = b[iB]
            iB++ // uma vez adicionado um elemento ao array final, incrementamos o índice do array B
        }
        else {
            a[iA] = c[iC]
            iC++
        }
        iA++
    }

    /*
    // versão mais compacta
    while (iB < b.size) {
        a[iA++] = b[iB++]
    }
    while (iC < c.size) {
        a[iA++] = c[iC++]
    }
    */
}

// versão alternativa
fun merge(a: IntArray, left: Int, mid: Int, right: Int) {
    // declarar os arrays b e c
    val b = IntArray(mid - left + 1)
    val c = IntArray(right - mid)

    // preencher os arrays b e c
    for (i in b.indices) {
        b[i] = a[i+left] // para começar a substituir em a na posição left e não em a[0]
    }
    for (i in c.indices){
        c[i] = a[i+mid+1]
    }

    // chamada recursiva
    merge(a, left, right, b, c)
}

/*
* Complexidade temporal: O(n lg n)
* Complexidade espacial:
 */
fun mergeSort(a: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(a, left, mid)
        mergeSort(a, mid+1, right)
        merge(a, left, mid, right)
    }
}