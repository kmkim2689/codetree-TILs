import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val seq = IntArray(n) { sc.nextInt() }

fun main() {
    var res = 0
    var idx = 0

    while(idx in (0..n-1)){
        idx++
        if(idx >=n ) {
            break
        }

        if(seq[idx] != 0) {
            res++
            continue
        }
    }
    println(res)
}



/*


res: 0 에서 시작
seq: n 개의 수들 배열: 0~n-1

from 0
if next is 0 -> next++

while next is not 0
    next++

check next is in seq




*/