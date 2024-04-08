import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, t) = br.readLine().trim().split(" ").map { it.toInt() }
    val (r, c, d) = br.readLine().trim().split(" ")
    // 격자 상의 계산을 위해 1을 빼준다.
    var position = Position(r.toInt() - 1, c.toInt() - 1)
    val directions = listOf(
        "U", "R", "D", "L"
    )
    val directionInfo = listOf(
        Position(-1, 0),
        Position(0, 1),
        Position(1, 0),
        Position(0, -1)
    )
    var index = directions.indexOf(d)
    var currDir = directionInfo[index]
    repeat(t) {
        val currPosition = position + currDir
        if (currPosition.r in 0 until n && currPosition.c in 0 until n) {
            position = currPosition
        } else {
            index = (index + 2) % 4
            currDir = directionInfo[index]
        }
    }

    // 격자 상 행, 열 단위로 표현하기 위해(1부터 시작) 다시 1을 더해준다.
    println("${position.r + 1} ${position.c + 1}")
}

data class Position(
    val r: Int = 0,
    val c: Int = 0
) {
    operator fun plus(other: Position): Position {
        return Position(this.r + other.r, this.c + other.c)
    }
}

/*
up right down left
Position(-1, 0)
Position(0, 1)
Position(1, 0)
Position(0, -1)
*/