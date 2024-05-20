import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tab = IntArray(n+1) { 0 }

fun main(){
    if(n == 1) {
        println(1)
        return
    }
    if(n == 2) {
        println(2)
        return
    }
    
    tab[1] = 1
    tab[2] = 2
    
    for (i in 3 .. n) {
        tab[i] = (tab[i-2] + tab[i-1]) % 10_007
    }
    println(tab[n])
}