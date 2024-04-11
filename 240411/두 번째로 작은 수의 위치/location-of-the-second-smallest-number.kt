import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map { it.toInt() }
    val sortedNumbers = numbers.sorted()
    var minimumNum = numbers.min()
    var isSecond = false
    var secondIndex: Int = -1
    sortedNumbers.forEachIndexed loop@ { index, number ->
        if (number > minimumNum!! && isSecond == false) {
            secondIndex = index + 1
            minimumNum = number
            isSecond = true
        } else if (number == minimumNum && isSecond == true) {
            secondIndex = -1
            return@loop
        }
    }
    if (secondIndex != 1) {
        secondIndex = numbers.indexOf(minimumNum) + 1
    }

    if (numbers.distinct().size == 1) {
        secondIndex = -1
    }

    println(secondIndex)
}