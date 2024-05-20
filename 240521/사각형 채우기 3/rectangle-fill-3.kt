import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tab = LongArray(n + 1) { 0 }
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

    tab[0] = 1
    tab[1] = 2
    tab[2] = 7
    for (i in 3..n) {
        tab[i] = (2 * tab[i - 1] + 3 * tab[i - 2]) % MOD
        for (k in 3..i) {
            tab[i] = (tab[i] + 2 * tab[i - k]) % MOD
        }
    }


    println(tab[n])
}

/*
n = int(input())

d = [0]*(n+1)
d[0], d[1] = 1, 2

for i in range(2, n+1):
    d[i] = (d[i-1]*2 + d[i-2]*3) % 1000000007
    for j in range(i-3, -1, -1):  # 건수가 매번 2개임
        d[i] = (d[i] + d[j]*2) % 1000000007

print(d[n])
*/