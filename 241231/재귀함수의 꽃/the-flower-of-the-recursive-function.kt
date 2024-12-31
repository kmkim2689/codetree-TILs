fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun rec(num: Int) {
        if (num == 0) return

        bw.write("$num ")
        rec(num - 1)
        bw.write("$num ")
    }

    rec(n)

    bw.flush()
    bw.close()
}