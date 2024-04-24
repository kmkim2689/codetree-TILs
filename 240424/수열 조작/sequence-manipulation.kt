import java.util.Deque
import java.util.ArrayDeque

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val deque: Deque<Int> = ArrayDeque<Int>()
    val n = br.readLine().trim().toInt()
    repeat(n) { deque.addLast(it + 1) }

    while (deque.size > 1) {
        deque.pollFirst()
        deque.addLast(deque.pollFirst())
    }

    write(deque.first().toString())

    close()
}