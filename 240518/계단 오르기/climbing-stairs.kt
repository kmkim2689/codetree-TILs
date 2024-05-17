val bw = System.out.bufferedWriter()
private lateinit var result: MutableList<Int>

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().trim().toInt()
    result = MutableList(n + 1) { -1 }
    val result = solve(n)
    bw.write("${result % 10007}")
    bw.close()
}

fun solve(height: Int): Int {
    if (height == 2 || height == 3 || height == 4) {
        result[height] = 1
        return result[height]
    }
    if (result[height] != -1) {
        return result[height]
    }

    val first: Int = if (height - 2 <= 1) {
        0
    } else if ((height - 2) in 2..4) {
        1
    } else {
        result[height - 2] = solve(height - 4) + solve(height - 5)
        result[height - 2]
    }

    val second: Int = if (height - 3 <= 1) {
        0
    } else if ((height - 3) in 2..4) {
        1
    } else {
        result[height - 3] = solve(height - 5) + solve(height - 6)
        result[height - 3]
    }


    result[height] = first + second
    return result[height]
}