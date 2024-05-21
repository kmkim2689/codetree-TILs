val bw = System.out.bufferedWriter()

fun main() {
    val br = System.`in`.bufferedReader()
    val (x, y) = br.readLine().trim().split(" ").map(String::toInt)
    var count = 0
    for (i in x..y) {
        if (isSymmetrical(i.toString())) {
            count++
        }
    }

    bw.write(count.toString())
    bw.close()
}

fun isSymmetrical(str: String): Boolean {
    for (i in 0 until str.length / 2) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        } 
    }

    return true
}