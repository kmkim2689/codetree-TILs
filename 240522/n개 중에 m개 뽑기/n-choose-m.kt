val bw = System.out.bufferedWriter()
val result = mutableListOf<Int>()
val total = mutableListOf<List<Int>>()
// private lateinit var status: MutableList<Boolean>

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().trim().split(" ").map(String::toInt)
    // status = MutableList(n + 1) { false }
    backtracking(1, n, m)
    bw.close()
}

fun backtracking(currNum: Int, maxNum: Int, maxSize: Int) {
    if (result.size == maxSize) {
        result.forEach {
            bw.write("${it} ")
        }
        bw.write("\n")
    }

    for (i in 1..maxNum) {
        if (i !in result && i > (result.max() ?: 0)) {
           result.add(i)
        //    status[i] = true
           backtracking(currNum + 1, maxNum, maxSize)
           result.removeAt(result.size - 1)
        //    status[i] = false
        }
    }
}