fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var (a, b) = br.readLine().trim().split(" ").map(String::toInt)
    if (a > b) {
        b += 10
        a *= 2
    } else {
        a += 10
        b *= 2
    }

    bw.write("$a $b")
    bw.flush()
    bw.close()
}