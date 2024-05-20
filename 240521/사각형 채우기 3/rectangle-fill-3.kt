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
    tab[1]= 2
    tab[2] = 7
    for (i in 3 .. n) {
        tab[i] = (3 * tab[i - 2] + 2 * tab[i - 1] + 2) % 1_000_000_007
    }
    println(n)
}