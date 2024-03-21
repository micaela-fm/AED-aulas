package dia.chapter6
import dia.chapter2.exchange

fun increaseKey(array: Array<Int>, n: Int, pos: Int) {
    var actualPos = pos
    var pai = parent(actualPos)
    while (actualPos > 0 && array[actualPos] > array[pai]) {
        exchange(array, actualPos, pai)
        actualPos = pai
        pai = parent(actualPos)
    }
}


fun peak(): Int {
    TODO()
}

fun offer(e: Int) {
    TODO()
}

fun poll(): Int {
    TODO()
}

fun isEmpty(): Boolean {
    TODO()
}

