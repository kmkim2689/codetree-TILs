import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val lengths = br.readLine().trim().split(" ").map(String::toInt)
    var count = 0

    for (i in 0 until lengths.size) {
        for (j in (i + 1) until lengths.size) {
            for (k in (j + 1) until lengths.size) {
                if (lengths[i] <= lengths[j] && lengths[j] <= lengths[k]) count++
            }
        }
    }

    println(count)
}