val bw = System.out.bufferedWriter()
val memo: MutableList<Int> = MutableList(46) { -1 }

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    bw.write("${fib(n)}")
    bw.close()
}

fun fib(number: Int): Int {
    if (number == 1 || number == 2) {
        memo[number] = 1
        return memo[number]
    }
    if (memo[number] != -1) return memo[number]
    memo[number] = fib(number - 1) + fib(number - 2)
    return memo[number]
}