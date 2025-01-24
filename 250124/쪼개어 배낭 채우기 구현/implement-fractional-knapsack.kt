fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val jewList = List(n) {
        val (w, v) = br.readLine().trim().split(" ").map(String::toInt)
        w to v
    }.sortedByDescending { (it.second / it.first).toDouble() }

    var leftW = m
    var sum: Double = 0.0
    for (jew in jewList) {
        val weight = jew.first
        val value = jew.second
        if (leftW >= weight) {
            sum += value.toDouble()
            leftW -= weight
        } else {
            val availableFraction = (leftW.toDouble() / weight.toDouble())
            sum += (value * availableFraction)
            break
        }
    }

    bw.write("%.3f".format(sum))

    bw.flush()
    bw.close()
}