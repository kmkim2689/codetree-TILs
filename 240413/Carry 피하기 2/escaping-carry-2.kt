import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = List(n) { br.readLine() } // 일단 문자열 형태로...
    var maxValue = -1

    for (i in 0 until numbers.size - 2) {
        for (j in i + 1 until numbers.size - 1) {
            for (k in j + 1 until numbers.size) {
                val calculationNums = mutableListOf(numbers[i], numbers[j], numbers[k])
                val maxLength = calculationNums.map(String::toInt).max().toString().length
                val calculatedNums = mutableListOf<List<Int>>()
                calculationNums.forEach {
                    val nums = mutableListOf<Int>()
                    val paddedNumber = it.padStart(maxLength, '0')
                    paddedNumber.forEach { nums.add(it.toString().toInt()) }
                    calculatedNums.add(nums)
                }

                val result = mutableListOf<Int>()
                calculatedNums[0].zip(calculatedNums[1]).zip(calculatedNums[2]) { (a, b), c ->
                    result.add(a + b + c)
                }

                var qualified = true
                result.forEach {
                    if (it >= 10) qualified = false
                }

                if (qualified == true) {
                    val total = result.joinToString("").toInt()
                    if (total > maxValue) maxValue = total
                }
            }
        }
    }

    println(maxValue)
}