import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a: List<Int> = br.readLine().trim().map { it.toString().toInt() }
    var maxValue = Int.MIN_VALUE
    for (i in 0 until a.size) {
        val numbers = a.toMutableList()
        numbers[i] = generateReversedNumber(numbers[i])
        var curr = 0
        numbers.forEachIndexed { index, num ->
            val mult = numbers.size - 1 - index
            curr += ((2.0).pow(mult) * num).toInt()
        }
        if (curr > maxValue) maxValue = curr
    }

    println(maxValue)
}

fun generateReversedNumber(num: Int): Int {
    return when (num) {
        0 -> 1
        1 -> 0
        else -> throw IllegalArgumentException()
    }
}

/*
Kotlin에서 제곱하는 방법
import kotlin.math.pow
Double.pow(정수 or float or double) -> 반환값이 double임에 유의

Kotlin에서 절댓값 씌우는 방법
import kotlin.math.abs
abs(정수)
*/