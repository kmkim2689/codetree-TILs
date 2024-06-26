import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()
val tabDp = IntArray(n + 1) { 0 }

fun main() {
    if(n == 2 || n == 3) {
        println(1)
        return
    }

    tabDp[2] = 1
    tabDp[3] = 1

    for(i in 4 .. n) {
        tabDp[i] = (tabDp[i - 3] + tabDp[i - 2]) % 10_007
    }
    println(tabDp[n])
}


/*

n = 2 -> 1
n = 3 -> 1
n = 4 -> 1
n = 5 -> 2 // (2,3) (3,2)
n = 6 -> 2 // (2,2,2) (3,3)
n = 7 -> 3 // (2,2,3) (2,3,2) (3,2,2)
n = 8 -> 4 // (2,2,2,2) (2,3,3) (3,2,3) (3,3,2)  // 2를 뺐을 때 6. 3을 뺐을 때 5 즉, 6의 2 + 5의 2 => 4
n = 9 -> 5 // (2,2,2,3) (2,2,3,2) (2,3,2,2) (3,2,2,2) (3,3,3) 5. // 2 뺏을 때 7 => 3. 3 뺐을 때 6 => 2. ==> 5
n = 10 -> 7. // (2,2,2,2,2) (2,2,3,3) (2,3,2,3) (2,3,3,2) (3,2,2,3) (3,2,3,2) (3,3,2,2) 7. // 2 뺏을 때 8 => 4. 3 뺏을 때 7 => 3.


*/