import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var position = Position()

    var result = -1
    var time = 0

    val directions = mapOf(
        "N" to Position(-1, 0),
        "E" to Position(0, 1),
        "S" to Position(1, 0),
        "W" to Position(0, -1)
    )

    repeat(n) loop@{
        val (dir, dis) = br.readLine().split(" ")
        repeat(dis.toInt()) {
            position += directions[dir] ?: return@loop
            time++
            if (position.r == 0 && position.c == 0) {
                result = time
                return@loop
            }
        }
    }

    println(result)
}

data class Position(
    val r: Int = 0,
    val c: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(this.r + other.r, this.c + other.c)
    }
}