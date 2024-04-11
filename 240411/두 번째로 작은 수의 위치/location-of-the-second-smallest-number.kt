import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map { it.toInt() }
    var minimumNum = numbers.first()
    var isSecond = false
    var secondIndex: Int = -1
    numbers.forEachIndexed loop@ { index, number ->
        if (number > minimumNum && isSecond == false) {
            secondIndex = index + 1
            isSecond = true
        } else if (number == minimumNum && isSecond == true) {
            secondIndex = -1
            return@loop
        }
    }
    println(secondIndex)
}