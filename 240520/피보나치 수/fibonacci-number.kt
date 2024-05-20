import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tabDp = IntArray(n + 1) {0}

fun main() {
    tabDp[1] = 1
    if(n == 1) {
        println(1)
        return
    }

    for(i in 2 .. n) {
        tabDp[i] = tabDp[i-2] + tabDp[i-1]
    }
    println(tabDp[n])
}