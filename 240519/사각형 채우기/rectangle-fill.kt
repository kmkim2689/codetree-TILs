val bw = System.out.bufferedWriter()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()

    val answer = MutableList(n + 1) { -1 }
    answer[0] = 0
    answer[1] = 1
    answer[2] = 2
    answer[3] = 3
    for (i in 4..n) {
        answer[i] = (answer[i - 1] + answer[i - 2]) % 10007
    }
    bw.write(answer[n].toString())
    bw.close()
}