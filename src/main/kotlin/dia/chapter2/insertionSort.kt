package dia.chapter2

// Complexidade temporal - O(n^2)
// Complexidade espacial . O(1)
fun insertionSort(a: IntArray, l: Int, r: Int) {
    for (i in l+1..r) {
        val v = a[i]        // v guarda o elemento a comparar
        var j = i
        while (j > l && v < a[j-1]) {
            a[j] = a[j-1]   // coloca um elemento do array ordenado na posição do elemento a comparar
            j--
        }
        a[j] = v // coloca o elemento a comparar na posição do elemento do array ordenado
    }
}
