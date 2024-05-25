val bw = System.out.bufferedWriter()
val currNums = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()

    backtracking(1, n)
    bw.close()
}

fun backtracking(curr: Int, max: Int) {
    if (curr == max + 1) {
        currNums.forEach {
            bw.write("$it ")
        }
        bw.write("\n")
        return
    }

    for (i in max downTo 1) {
        if (i !in currNums) {
            currNums.add(i)
            backtracking(curr + 1, max)
            currNums.removeAt(currNums.size - 1)
        }
    }
}