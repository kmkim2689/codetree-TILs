import java.util.Scanner

const val ZERO = 0

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val numbers = List(n) { sc.nextInt() }

    var isMinus = numbers[0].checkMinus()
    var curr = 1
    var max = 1
    numbers.forEachIndexed { index, number ->
        if (index > 0) {
            if (number.checkMinus() == isMinus) {
                curr++
            } else {
                if (curr > max) max = curr
                curr = 1
            }
            isMinus = number.checkMinus()
        }
    }

    if (curr > max) max = curr

    println(max)
}

fun Int.checkMinus(): Boolean = this < 0