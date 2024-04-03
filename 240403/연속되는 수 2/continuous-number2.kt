import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n: Int = sc.nextInt()
    val numbers: List<Int> = List(n) { sc.nextInt() }
    var curr = 0
    var max = 1
    numbers.forEachIndexed { index, number ->
        if (index == 0 || numbers[index - 1] == numbers[index]) {
            curr++
        } else {
            if (curr > max) max = curr
            curr = 1
        }
    }
    println(max)
}