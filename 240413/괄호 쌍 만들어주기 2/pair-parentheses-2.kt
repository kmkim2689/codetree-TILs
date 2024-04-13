import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().trim()
    var count = 0

    for (i in 0 until a.length - 2) {
        if (a[i] == '(' && a[i + 1] == '(') {
            for (j in i + 2 until a.length - 1) {
                if (a[j] == ')' && a[j + 1] == ')') {
                    count++
                }
            }
        } 
    }

    println(count)
}