import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var arr = IntArray(n) { sc.nextInt() }

    // 최대값 찾기
    val maxNum = arr.max()
    // 최대 자리수 계산
    val maxDigit = maxNum.toString().length

    var exp = 1
    for (digit in 1..maxDigit) {
        // 버킷 초기화
        val bucket = Array(10) { mutableListOf<Int>() }

        // 현재 자리수에 따른 값 분배
        for (item in arr) {
            val index = (item / exp) % 10
            bucket[index].add(item)
        }

        // 버킷에서 다시 배열로 수집
        var index = 0
        for (b in bucket) {
            for (num in b) {
                arr[index++] = num
            }
        }
        exp *= 10
    }

    // 결과 출력
    println(arr.joinToString(" "))
}


// fun main() {
//     val sc = Scanner(System.`in`)
//     val n = sc.nextInt()
//     var arr = IntArray(n) { sc.nextInt() }

//     val maxNum = arr.max()
//     val maxDigit = maxNum.toString().length - 1 // 3 자리 수 이면 2

//     for(digit in 0 .. 6) { // digit: 자리수
//         // 나누는 수
//         var x = 10
//         // 새로 값을 저장할 리스트
//         val newList = List(10) { mutableListOf<Int>() }

//         for(item in arr){
//             var nowDigit = ((item % x).toString().first() - '0').toInt()
//             newList[nowDigit].add(item)
//         }

//         val stored = mutableListOf<Int>()

//         for(i in 0 .. 9) {
//             for(j in 0 until newList[i].size) {
//                 stored.add((newList[i])[j])
//             }
//         }
//         x = x * 10
//         arr = stored.toIntArray()
//     }
//     for(item in arr){
//         print("${item} ")
//     }

// }


// /*
// 6
// 5 2 6 1 3 8
// */