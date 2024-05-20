import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tab = IntArray(n + 1) { 0 }

fun main() {
    
    if(n == 1) {
        println(2)
        return
    }
    if( n == 2) {
        println(7)
        return
    }

    if( n == 3) {
        println(22)
        return
    }
    tab[0] = 1
    tab[1] = 2
    tab[2] = 7
    for (i in 4 .. n) {
        tab[i] = ((2 * tab[i-3]) + (3 * tab[i - 2]) + (2 * tab[i - 1])) % 1_000_000_007
    }
    println(tab[n])
}