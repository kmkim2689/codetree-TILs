fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun recursiveAscending(num: Int) {
        if (num == 0) return
        recursiveAscending(num - 1)
        bw.write("$num ")
    }

    fun recursiveDescending(num: Int) {
        if (num == 0) return
        bw.write("$num ")
        recursiveDescending(num - 1)
    }

    recursiveAscending(n)
    bw.write("\n")
    recursiveDescending(n)

    bw.flush()
    bw.close()
}