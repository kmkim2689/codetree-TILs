import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var arr = IntArray(n) { sc.nextInt() } // 초기 배열

    val maxDigit = (arr.max()).toString().length // 초기 배열에서 최대값의 자리 수. 329 가 최대값이면 자리 수 3

    var exp = 1 // 자리 수를 찾기 위한 나누는 값

    for(digit in 1 .. maxDigit) {
        val bucket = Array(10) { mutableListOf<Int>() }

        // 현재 자리수에 따른 값 분배
        for(item in arr){
            val idx = (item / exp) % 10
            bucket[idx].add(item)
        }

         // 버키에서 다시 수집
        var idx = 0
        for(b in bucket) {
            for (num in b) {
                arr[idx++] = num
            }
        }
        exp *= 10
    }
   
    // 결과 출력
    println(arr.joinToString(" "))
}