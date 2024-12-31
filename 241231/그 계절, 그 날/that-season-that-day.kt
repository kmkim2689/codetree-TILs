fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (y, m, d) = br.readLine().trim().split(" ").map(String::toInt)
    var special = false
    if (y % 4 == 0) {
        if (y % 100 == 0 && y % 400 == 0) {
            special = true
        } else if (y % 100 != 0) {
            special = true
        }
    }

    var result = when (m) {
        3, 4, 5 -> "Spring"
        6, 7, 8 -> "Summer"
        9, 10, 11 -> "Fall"
        12, 1, 2 -> "Winter"
        else -> throw error("invalid month")
    }

    when (m) {
        2 -> {
            if (special) {
                if (d > 29) result = "-1"
            } else {
                if (d > 28) result = "-1"
            }
        }
        4, 6, 9, 11 -> {
            if (d > 30) result = "-1"
        }
    }

    bw.write(result)
    bw.flush()
    bw.close()
}