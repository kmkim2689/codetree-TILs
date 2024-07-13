import java.util.*

const val DIR_NUM = 4
const val MAX_NUM = 25

var n = 0
val grid = Array(MAX_NUM) { IntArray(MAX_NUM) }
val visited = Array(MAX_NUM) { BooleanArray(MAX_NUM) }
val peopleNums = ArrayList<Int>()
var peopleNum = 0

fun inRange(x: Int, y: Int): Boolean {
    return x in 0 until n && y in 0 until n
}

fun canGo(x: Int, y: Int): Boolean {
    if (!inRange(x, y)) return false
    if (visited[x][y] || grid[x][y] == 0) return false
    return true
}

fun DFS(x: Int, y: Int) {
    //0: right, 1: down, 2: left, 3: up
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    for (dir in 0 until DIR_NUM) {
        val newX = x + dx[dir]
        val newY = y + dy[dir]

        if (canGo(newX, newY)) {
            visited[newX][newY] = true
            peopleNum++
            DFS(newX, newY)
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    for (i in 0 until n) {
        for (j in 0 until n) {
            grid[i][j] = sc.nextInt()
        }
    }

    for (i in 0 .. n-1) {
        for (j in 0 .. n-1) {
            if (canGo(i, j)) {
                visited[i][j] = true
                peopleNum = 1

                DFS(i, j)

                peopleNums.add(peopleNum)
            }
        }
    }

    Collections.sort(peopleNums)

    println(peopleNums.size)
    for (num in peopleNums) {
        println(num)
    }
}