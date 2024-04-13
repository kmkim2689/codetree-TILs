import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)
    var maxValue = Int.MIN_VALUE

    for (i in 0 until numbers.size - 2) {
        for (j in i + 2 until numbers.size) {
            val currTotal = numbers[i] + numbers[j]
            if (currTotal > maxValue) maxValue = currTotal
        }
    }

    println(maxValue)
}