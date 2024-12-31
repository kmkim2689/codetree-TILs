fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val numbers = br.readLine().trim().split(" ").map(String::toInt)

    repeat(m) {
        val (s, e) = br.readLine().trim().split(" ").map(String::toInt)
        var sum = 0
        for (idx in s - 1..e - 1) {
            sum += numbers[idx]
        }
        bw.write("${sum}\n")
    }

    bw.flush()
    bw.close()
}