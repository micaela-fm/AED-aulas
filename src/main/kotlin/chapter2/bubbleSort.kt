package chapter2

/*
* Complexidade temporal:
*  pior caso - n^2
*  melhor caso - n^2
* Complexidade espacial:
 */
fun bubbleSort(array: IntArray, left: Int, right: Int) {
    for (i in left until right) {
        for (j in right downTo i+1) {
            if (array[j] < array[j-1]) {
                exchange(array, i, j)
            }
        }
    }
}