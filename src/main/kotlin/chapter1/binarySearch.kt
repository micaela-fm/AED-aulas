package chapter1

fun binarySearchRecursive(a: IntArray, left: Int, right: Int, elem: Int): Int {
    if(right < left) return -1
    val mid = (left + right) / 2
    return if(a[mid] == elem) mid
    else {
        if (a[mid] > elem)
            binarySearchRecursive(a, left, mid - 1, elem)
        else binarySearchRecursive(a, mid+1, right, elem)
    }
}

/*
Complexidade temporal - O(lg n)
Complexidade espacial - O()
 */
fun binarySearchIterative(a: IntArray, left: Int, right: Int, elem: Int): Int {
    var l = left
    var r = right
    while (l <= r) {
        val mid = (l + r) / 2
        if (a[mid] == elem) return mid // modificar para upper/lower bound
        else {
            if (a[mid] < elem) l = mid + 1
            else r = mid - 1 // linha certa para lower bound, alterar para o upper bound
        }
    }
    return -1 // modificar para upper/lower bound
}

