import java.io.BufferedReader
import java.io.InputStreamReader

// 좌표 -> 위치에 대한 정보를 그대로 활용하기보다는, 배열을 통해 존재 여부를 mark!
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().trim().split(" ").map(String::toInt)
    val players: List<Player> = List(n) {
        val (position, flag) = br.readLine().trim().split(" ")
        Player(position.toInt(), flag)
    }
    val maxDistance = players.map(Player::position).max()
    val locationInfo = MutableList(10001) { "" }.also { info ->
        players.forEach { player -> info[player.position] = player.flag }
    }
    var maxValue = Int.MIN_VALUE

    for (i in 1..10000 - k) {
        val result = locationInfo.slice(i..i + k)
        var total = result.map { 
            when (it) {
                "G" -> 1
                "H" -> 2
                else -> 0
            }
        }.sum()
        if (total > maxValue) maxValue = total
    }

    println(maxValue)
}

data class Player(
    val position: Int,
    val flag: String
)