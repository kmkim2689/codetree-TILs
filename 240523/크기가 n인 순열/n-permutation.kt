val bw = System.out.bufferedWriter()
val currNumbers = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    backtracking(1, n)
    bw.close()
}

fun backtracking(curr: Int, max: Int) {
    if (curr == max + 1) {
        currNumbers.forEach {
            bw.write("$it ")
        }
        bw.write("\n")
        return
    }

    for (i in 1..max) {
        if (i !in currNumbers) {
            currNumbers.add(i)
            backtracking(curr + 1, max)
            currNumbers.removeAt(currNumbers.size - 1)
        }
    }
}