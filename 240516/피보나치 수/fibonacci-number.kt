val bw = System.out.bufferedWriter()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    bw.write("${fib(n)}")
    bw.close()
}

fun fib(number: Int): Int {
    if (number == 1 || number == 2) return 1
    return fib(number - 1) + fib(number - 2)
}