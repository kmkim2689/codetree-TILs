import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var arr = IntArray(n) { sc.nextInt() }

    val maxNum = arr.max()
    val maxDigit = maxNum.toString().length - 1 // 3 자리 수 이면 2

    for(digit in maxDigit downTo 0) { // digit: 자리수
        // 나누는 수
        var x = 1
        // 새로 값을 저장할 리스트
        val newList = List(10) { mutableListOf<Int>() }

        for(item in arr){
            val nowDigit = item / x
            newList[nowDigit].add(item)
        }

        val stored = mutableListOf<Int>()

        for(i in 0 .. 9) {
            for(j in 0 until newList[i].size) {
                stored.add((newList[i])[j])
            }
        }
        x = x * 10
        arr = stored.toIntArray()
    }
    for(item in arr){
        print("${item} ")
    }

}