import java.io.BufferedReader
import java.io.InputStreamReader

// 구간 단위 완전탐색 : 시작 위치를 기준으로 진행 -> 어디까지 순회할지 결정
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val numbers = br.readLine().trim().split(" ").map(String::toInt)
    var maxValue = Int.MIN_VALUE
    for (i in 0..(n - k)) {
        val slicedNums = numbers.slice(i until i + k)
        val total = slicedNums.sum()
        if (total > maxValue) maxValue = total
    }

    println(maxValue)
}