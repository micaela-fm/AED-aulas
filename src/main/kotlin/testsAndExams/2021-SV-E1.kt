package testsAndExams

/*
3. (3.5)(FOLHA5) Realize a função fun segment( v: IntArray, l: Int, r: Int, element: Int )
que segmenta o sub-array (v, l, r) em relação a element, isto é, no sub-array (v, l, r),
os elementos menores que element terão de ocorrer antes de todos os elementos maiores do que element.
Note que element pode não ocorrer no sub-array (v, l, r).
*/

fun segment (v: IntArray, l: Int, r: Int, element: Int) {
    if (l >= r) return

    var i = l
    var j = r

    while (i <= j) {
        if (v[i] >= element) {
            if (v[j] < element) {
                val aux = v[i]
                v[i] = v[j]
                v[j] = aux
            }
            j--
        }
        i++
    }
}
