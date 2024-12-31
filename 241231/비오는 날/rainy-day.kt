fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().trim().toInt()
    val forecasts = mutableListOf<Forecast>()
    repeat(n) {
        val input = br.readLine().trim().split(" ")
        val date = input.first().split("-").map(String::toInt)
        val day = input[1]
        val weather = input[2]
        forecasts.add(
            Forecast(date[0], date[1], date[2], day, weather)
        )
    }
    forecasts.sort()
    for (elem in forecasts) {
        if (elem.weather == "Rain") {
            val format = "%04d-%02d-%02d".format(elem.year, elem.month, elem.dayOfMonth)
            bw.write("${format} ${elem.day} ${elem.weather}")
            break
        }
    }

    bw.flush()
    bw.close()
}

data class Forecast(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
    val day: String,
    val weather: String
) : Comparable<Forecast> {
    override fun compareTo(other: Forecast): Int {
        return if (year == other.year) {
            if (month == other.month) {
                dayOfMonth - other.dayOfMonth
            } else {
                month - other.month
            }
        } else {
            year - other.year
        }
    }
}
