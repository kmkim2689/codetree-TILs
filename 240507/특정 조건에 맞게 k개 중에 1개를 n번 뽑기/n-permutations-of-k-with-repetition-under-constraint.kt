val bw = System.out.bufferedWriter()
val curr = mutableListOf<Int>()
val results = mutableListOf<List<Int>>()

fun main() {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().trim().split(" ").map(String::toInt)
    backtracking(1, k, n)
    results.forEach {
        bw.write("${it.joinToString(" ")}\n")
    }
    bw.close()
}

fun backtracking(currSize: Int, maxNumber: Int, maxSize: Int) {
    if (currSize == maxSize + 1) {
        results.add(curr.toList())
        return
    }

    for (i in 1..maxNumber) {
        if (curr.size <= maxSize && curr.count { it == i } < 2) {
            curr.add(i)
            backtracking(currSize + 1, maxNumber, maxSize)
            curr.removeAt(curr.size - 1)
        }
    }
}