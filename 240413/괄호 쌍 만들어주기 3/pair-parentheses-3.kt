import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    var count = 0
    a.forEachIndexed { index, char ->
        if (char == '(') {
            for (i in (index + 1) until a.length) {
                if (a[i] == ')') count++
            }
        }
    }

    println(count)
}