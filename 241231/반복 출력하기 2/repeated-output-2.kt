fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun greet(num: Int) {
        if (num == 0) return
        greet(num - 1)
        bw.write("HelloWorld\n")
    }

    greet(n)

    bw.flush()
    bw.close()
}