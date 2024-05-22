package trees

import java.util.*


// percurso em largura ou por nível
fun <E> percursoEmLargura(root: Node<E>?) {
    val queue = LinkedList<Node<E>>()

    if (root != null) queue.offer(root)

    while (!queue.isEmpty()) {
        val current = queue.pop()
        println(current.item)

        if (current.left != null) queue.offer(current.left)

        if (current.right != null) queue.offer(current.right)
    }
}