import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine()
    var count = 0
    for (i in 0 until str.length - 2) {
        if (str[i] == 'C') {
            for (j in (i + 1) until str.length - 1) {
                if (str[j] == 'O') {
                    for (k in (j + 1) until str.length) {
                        if (str[k] == 'W') {
                            count++
                        }
                    }   
                }
            }
        }
    }

    println(count)
}