import java.util.Deque
import java.util.ArrayDeque

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val deque: Deque<Int> = ArrayDeque<Int>()
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val order = br.readLine().trim().split(" ")
        when (order[0]) {
            "push_front" -> deque.addFirst(order[1].toInt())
            "push_back" -> deque.addLast(order[1].toInt())
            "pop_front" -> write("${deque.pollFirst()}\n")
            "pop_back" -> write("${deque.pollLast()}\n")
            "size" -> write("${deque.size}\n")
            "empty" -> {
                val isEmpty = if (deque.isEmpty()) 1 else 0
                write("$isEmpty\n")
            }
            "front" -> write("${deque.peekFirst()}\n")
            "back" -> write("${deque.peekLast()}\n")
            else -> Unit
        }
    }

    close()
}