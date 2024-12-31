fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun rec(num: Int) {
        if (num == 0) return

        repeat(num) {
            bw.write("* ")
        }
        bw.write("\n")

        rec(num - 1)

        repeat(num) {
            bw.write("* ")
        }
        bw.write("\n")
    }

    rec(n)

    bw.flush()
    bw.close()
}