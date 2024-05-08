val bw = System.out.bufferedWriter()
val curr = mutableListOf<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().split(" ").map(String::toInt)
    backtracking(1, n, k)
    bw.close()
}

fun backtracking(
    currSize: Int,
    maxSize: Int,
    maxNumber: Int
) {
    if (currSize == maxSize + 1) {
        curr.forEach {
            bw.write("$it ")
        }
        bw.write("\n")
        return
    }

    for (i in 1..maxNumber) {
        if (curr.size < 2 || (curr[curr.size - 1] == i && curr[curr.size - 2] == i) == false) {
            curr.add(i)
            backtracking(currSize + 1, maxSize, maxNumber)
            curr.removeAt(curr.size - 1)
        }
    }
}