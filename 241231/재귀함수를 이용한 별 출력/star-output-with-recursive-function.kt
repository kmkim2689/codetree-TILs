fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    fun printStars(num: Int) {
        if (num == 0) return
        printStars(num - 1)
        repeat(num) {
            bw.write("*")
        }
        bw.write("\n")
    }

    printStars(n)

    bw.flush()
    bw.close()
}