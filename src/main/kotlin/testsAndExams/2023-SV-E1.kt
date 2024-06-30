package testsAndExams

fun identity(ar: IntArray, l: Int, r: Int): Int {
    if (l > r) return -1
    val i = (l + r) / 2
    return when{
        i == ar[i] -> i
        i < ar[i] -> identity(ar, l, i - 1)
        else -> identity(ar, i + 1, r)
    }
}

fun Array<Int>.isSubarray(v: Array<Int>): Boolean {
    var i = 0
    var j = 0

    while (i < v.size && j < this.size) {
        when{
            v[i] == this[j] -> {
                i++
                j++
            }
            v[i] < this[j] -> {
                i++
                j = 0
            }
            else -> return false
        }
    }
    return j == this.size
}

fun removeBetween(list: Node<Int>, min: Int, max: Int) {
    if (min > max)
        return

    var i = list.next
    var j = list.previous


    if (i.item!! > max || j.item!! < min)
        return

    while (i != j) {
        if (i.item in min..max) {
            if (j.item in min..max) {
                i = i.previous
                j = j.next
                i.next = j
                j.previous = i
                break
            } else j = j.previous
        } else i = i.next
    }
}

fun countNodesUntilLevel(root: trees.Node<Int>?, k: Int): Int {
    if (root == null || k < 1) return 0
    if (k == 1) return 1
    return 1 + countNodesUntilLevel(root.left, k-1) + countNodesUntilLevel(root.right, k-1)
}
