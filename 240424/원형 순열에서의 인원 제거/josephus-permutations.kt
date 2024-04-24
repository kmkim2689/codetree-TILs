import java.util.Queue
import java.util.LinkedList

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val queue: Queue<Int> = LinkedList<Int>().apply {
        repeat(n) { add(it + 1) }
    }
    
    while (queue.size > 0) {
        repeat(k - 1) {
            queue.add(queue.poll())
        }
        write("${queue.poll()} ")
    }

    close()
}