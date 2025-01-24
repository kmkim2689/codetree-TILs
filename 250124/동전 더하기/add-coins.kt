fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val units = List(n) { br.readLine().trim().toInt() }

    var min = Int.MAX_VALUE
    loop@ for (idx in units.size - 1 downTo 0) {
        var currIdx = idx
        var currLeft = k
        var count = 0
        while(currIdx >= 0 && currLeft >= 0) {
            if (units[currIdx] > currLeft) {
                currIdx--
            } else {
                currLeft -= units[currIdx]
                count++
                if (currLeft < 0) continue@loop
            }
        }

        if (count < min) min = count
    }

    bw.write(min.toString())
    bw.flush()
    bw.close()
}