fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val students = mutableListOf<Student>()
    repeat(n) { idx ->
        val (h, w) = br.readLine().trim().split(" ").map(String::toInt)
        students.add(Student(idx + 1, h, w))
    }

    students.sorted().forEach {
        bw.write("${it.h} ${it.w} ${it.number} \n")
    }

    bw.flush()
    bw.close()
}

data class Student(
    val number: Int,
    val h: Int,
    val w: Int,
) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return if (h == other.h) {
            other.w - w
        } else {
            h - other.h
        }
    }
}