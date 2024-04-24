import java.util.Queue
import java.util.LinkedList

fun main() = with(System.out.bufferedWriter()) {
    val queue: Queue<Int> = LinkedList()
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val order = br.readLine().trim().split(" ")
        when (order[0]) {
            "push" -> queue.add(order[1].toInt())
            "front" -> write("${queue.peek()}\n")
            "size" -> write("${queue.size}\n")
            "empty" -> {
                val isEmpty = queue.isEmpty()
                val result = if (isEmpty) 1 else 0
                write("$result\n")
            }
            "pop" -> write("${queue.poll()}\n")
            else -> Unit
        }
    }

    close()
}