import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tab = IntArray(n + 1) { 0 }
val MOD = 1_000_000_007
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
    for (i in 3 .. n) {
        tab[i] = ((2 * tab[i-1] + 3 * tab[i-2])) % MOD
        for(j in 3 .. i){
            tab[i] += (2 * tab[i-j])
        }
    }

    println(tab[n])
}