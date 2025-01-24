import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)

    val jewList = PriorityQueue<Pair<Int, Int>>() { o1, o2 ->
        val t1 = (o1.second).toDouble() / (o1.first).toDouble()
        val t2 = (o2.second).toDouble() / (o2.first).toDouble()

        if (t1 == t2) {
            o1.first - o2.first
        } else {
            if (t2 > t1) 1 else -1
        }
    }

    repeat(n) {
        val (w, v) = br.readLine().trim().split(" ").map(String::toInt)
        jewList.add(w to v)
    }

    var leftW = m
    var sum: Double = 0.0
    while (jewList.isNotEmpty()) {
        val jew = jewList.poll()
        val weight = jew.first
        val value = jew.second
        if (leftW >= weight) {
            sum += value.toDouble()
            leftW -= weight
        } else {
            val availableFraction = (leftW.toDouble() / weight.toDouble())
            sum += (value * availableFraction).toDouble()
            break
        }
    }

    bw.write("%.3f".format(sum))

    bw.flush()
    bw.close()
}