package chapter6

import chapter2.exchange

/**
 * Data class representing a user with a name, id, and priority.
 *
 * @property name The name of the user.
 * @property id The id of the user.
 * @property priority The priority of the user.
 */
data class Utente(val name: String, val id: Int, val priority: Int)

/**
 * Data class representing a priority queue.
 *
 * @property array The array of users.
 * @property cmp The comparator function used to compare users.
 * @property size The current size of the priority queue.
 */
data class PriorityQueue(val array: Array<Utente>, val cmp: (u1: Utente, u2: Utente) -> Int, var size: Int)

/**
 * Function to increase the key of a user in the priority queue.
 *
 * @param array The array of users.
 * @param n The size of the array.
 * @param pos The position of the user in the array.
 */
fun PriorityQueue.increaseKey(array: Array<Utente>, n: Int, pos: Int) {
    var actualPos = pos
    var pai = parent(actualPos)
    while (actualPos > 0 && pai >= 0 && cmp(array[pai], array[pos]) < 0) {
        exchange(array, actualPos, pai)
        actualPos = pai
        pai = parent(actualPos)
    }
}

/**
 * Function to decrease the key of a user in the priority queue.
 *
 * @param n The size of the array.
 * @param pos The position of the user in the array.
 * @param cmp The comparator function used to compare users.
 */
fun PriorityQueue.decreaseKey(n: Int, pos: Int, cmp: (u1: Utente, u2: Utente) -> Int) {
    var pai = parent(pos)
    var actualPos = pos
    while (pai >= 0 && cmp(array[pai], array[pos]) > 0) {
        exchange(array, actualPos, pai)
        actualPos = pai
        pai = parent(pai)
    }
}

/**
 * Function to restore the heap property at a given position in the priority queue.
 *
 * @param pos The position at which to restore the heap property.
 */
fun PriorityQueue.minHeapify(pos: Int) {
    var pai = pos
    val l = left(pos)
    val r = right(pos)
    if (l < size && cmp(array[l], array[pos]) < 0)
        pai = l
    if (l < size && cmp(array[l], array[pai]) > 0)
        pai = r
    if (pai != pos) {
        exchange(array, pai, pos)
        minHeapify(pai)
    }
}

/**
 * Function to check if the priority queue is empty.
 *
 * @return True if the priority queue is empty, false otherwise.
 */
fun PriorityQueue.isEmpty() = size == 0

/**
 * Function to get the user with the highest priority in the priority queue.
 *
 * @return The user with the highest priority, or null if the priority queue is empty.
 */
fun PriorityQueue.peek(): Utente? {
    return if (isEmpty()) null else array[0] // most prioritized at the head of the list
}

/**
 * Function to add a user to the priority queue.
 *
 * @param utente The user to be added.
 * @return True if the user was added successfully, false otherwise.
 */
fun PriorityQueue.offer(utente: Utente): Boolean {
    if (size == array.size) return false
    array[size++] = utente
    this.decreaseKey(size, size - 1, cmp)
    return true
}

/**
 * Function to remove and return the user with the highest priority from the priority queue.
 *
 * @return The user with the highest priority, or null if the priority queue is empty.
 */
fun PriorityQueue.poll(): Utente? {
    val ut = peek()

    if (ut != null) {
        array[0] = array[--size]
        minHeapify(0)
    }
    return ut
}