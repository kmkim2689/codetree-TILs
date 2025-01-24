fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().trim().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)

    var i = 0
    var j = 0
    var max = Int.MIN_VALUE
    var current = 0
    while (i < n && j < n) {
        current += numbers[j]
        if (current > max) {
            max = current
        }
        j++
        
        if (current < 0) {
            i = j
            current = 0
        }
    }

    bw.write(max.toString())

    bw.flush()
    bw.close()
}