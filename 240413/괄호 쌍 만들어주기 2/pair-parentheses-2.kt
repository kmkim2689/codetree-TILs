import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    var count = 0

    a.forEachIndexed { index, elem ->
        if (a[index] == '(' && a[index + 1] == '(') {
            for (j in index + 2 until a.length - 1) {
                if (a[j] == ')' && a[j + 1] == ')') {
                    count++
                }
            }
        } 
    }

    println(count)
}