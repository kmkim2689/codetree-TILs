import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val pq = PriorityQueue<Pair<Int, Int>>() { o1, o2 ->
        if (o1.second == o2.second) {
            o1.first - o2.first
        } else {
            o1.second - o2.second
        }
    }

    repeat(n) {
        val (s, e) = br.readLine().trim().split(" ").map(String::toInt)
        pq.add(s to e)
    }

    var available = 0
    var last = 0

    while (pq.isNotEmpty()) {
        val polled = pq.poll()
        if (last <= polled.first) {
            available++
            last = polled.second
        }
    }

    bw.write(available.toString())
    bw.flush()
    bw.close()
}