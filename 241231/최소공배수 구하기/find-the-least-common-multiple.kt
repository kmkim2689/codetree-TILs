fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    val num1 = n
    val num2 = m

    while (n > 0 && m > 0) {
        if (m > n) {
            m = m - n
        } else {
            n = n - m
        }
    }

    val div = if (m != 0) m else n
    val result = div * (num1 / div) * (num2 / div)
    
    bw.write(result.toString())

    bw.flush()
    bw.close()
}