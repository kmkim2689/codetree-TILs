import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()

var row = 0
var col = 0
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() {
    repeat(N) {
        val cmd = sc.next()
        val move = sc.nextInt()

        when(cmd) {
            "E" -> {
                row = row + dx[0] * move
                col = col + dy[0] * move
            }
            "S" -> {
                row = row + dx[1] * move
                col = col + dy[1] * move
            } 
            "W" -> {
                row = row + dx[2] * move
                col = col + dy[2] * move
            }
            "N" -> {
                row = row + dx[3] * move
                col = col + dy[3] * move
            }
        }
    }
    println("$row $col")
}