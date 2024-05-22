val bw = System.out.bufferedWriter()
val result = mutableListOf<Int>()
val total = mutableListOf<Set<Int>>()

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    backtracking(1, n, m)
    bw.close()
}

fun backtracking(currNum: Int, maxNum: Int, maxSize: Int) {
    if (result.size == maxSize) {
        total.add(result.toSet())
        result.forEach {
            bw.write("${it} ")
        }
        bw.write("\n")
    }

    for (i in 1..maxNum) {
        if (i !in result && (result + i).toSet() !in total) {
           result.add(i)
           backtracking(currNum + 1, maxNum, maxSize)
           result.removeAt(result.size - 1)
        }
    }
}