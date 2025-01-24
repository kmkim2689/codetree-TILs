import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)

    val pq = PriorityQueue<Int>() { o1, o2 ->
        o1 - o2
    }

    numbers.forEach { number ->
        pq.add(number)
    }

    var expenses = 0

    if (n == 1) {
        bw.write(expenses.toString())
        bw.flush()
        bw.close()
        return
    }
    
    while (pq.isNotEmpty()) {
        var n1 = pq.poll()
        val n2 = pq.poll()
        expenses += (n1 + n2)

        if (pq.isEmpty()) break

        pq.add(n1 + n2)
    }

    bw.write(expenses.toString())
    bw.flush()
    bw.close()
}