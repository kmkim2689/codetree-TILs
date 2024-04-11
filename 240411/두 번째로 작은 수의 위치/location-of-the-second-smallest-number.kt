import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map { it.toInt() }
    var minimumNum = numbers.first()
    var isSecond = false
    var secondIndex: Int = -1
    numbers.forEachIndexed { index, number ->
        if (number > minimumNum && isSecond == false) {
            secondIndex = index + 1
            minimumNum = number
        } else if (number == minimumNum && isSecond == true) {
            secondIndex = -1
            return
        }
    }
    println(secondIndex)
}