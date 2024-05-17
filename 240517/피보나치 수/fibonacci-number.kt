import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
var ans = 1

fun main(){
    println(pibo(n))
}

fun pibo(i: Int): Int {
    if(i == 1) return 1
    if(i == 2) return 1

    return pibo(i-2) * pibo(i-1)
}