import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().trim().split(" ").map(String::toInt)

    var minValue = Int.MAX_VALUE
    numbers.forEachIndexed { gatherIdx, distance ->
        var total = 0
        numbers.forEachIndexed { currIdx, value ->
            total += abs(currIdx - gatherIdx) * value
        }
        if (minValue > total) minValue = total
    }

    println(minValue)
}

// max / min의 초기값은 들어올 값보다 훨씬 작은 값으로
// Kotlin에서는 Int.MAX_VALUE, Int.MIN_VALUE로 할 수 있음