import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var position = Position()
    val info = listOf(
        "N" to Position(0, 1),
        "E" to Position(1, 0),
        "S" to Position(0, -1),
        "W" to Position(-1, 0)
    )

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    repeat(n) {
        val input = br.readLine().split(" ")
        val direction = info.find { input[0] == it.first }!!.second
        val dist = input[1].toInt()
        position = position.copy(
            position.x + dist * direction.x,
            position.y + dist * direction.y
        )
    }
    print("${position.x} ${position.y}")
}

data class Position(
    val x: Int = 0,
    val y: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(this.x + other.x, this.y + other.y)
    }
}