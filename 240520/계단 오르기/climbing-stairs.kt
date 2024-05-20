import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tabDp = IntArray(n) { 0 }

fun main() {
    if(n == 2 || n == 3) {
        println(1)
        return
    }

    tabDp[2] = 1
    tabDp[3] = 1

    for(i in 3 .. n) {
        tabDp[i] = tabDp[i - 2] + tabDp[i - 3]
    }
    println(tabDp[n])
}