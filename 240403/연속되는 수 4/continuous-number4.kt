import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val numbers = List(n) { sc.nextInt() }

    var currMax = 0
    var count = 0
    var max = 0
    numbers.forEachIndexed { index, number ->
        if (index == 0) {
            currMax = number
            count++
        } else {
            if (number > numbers[index - 1]) {
                count++
            } else {
                if (count > max) max = count
                currMax = number
                count = 1
            }
        }
    }

    if (count > max) max = count

    println(max)
}