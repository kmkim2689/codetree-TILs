val bw = System.out.bufferedWriter()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    val result: Array<Int> = Array(1001) { -1 }
    result[0] = 1 // 안 올라가는 방법은 한 가지
    result[1] = 0
    result[2] = 1
    result[3] = 1
    for (i in 4..n) {
        result[i] = (result[i - 2] + result[i - 3]) % 10007
    }
    bw.write("${result[n]}")
    bw.close()
}