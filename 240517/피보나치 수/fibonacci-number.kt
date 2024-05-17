import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
var ans = 1
val arr = IntArray(n) { -1 }

fun main(){
    println(pibo(n))
}

fun pibo(i: Int): Int {
    if(i == 1) return 1
    if(i == 2) return 1

    if(arr[i - 2]== -1){
        arr[i-2] = pibo(i-2)
    }

    if(arr[i-1] == -1) {
        arr[i-1] = pibo(i-1)
    }
    return arr[i-2] + arr[i-1]
}