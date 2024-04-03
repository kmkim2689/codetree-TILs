n, t = map(int, input().split())
numbers = list(map(int, input().split()))

count = 0
maxCount = 0
for number in numbers:
    if (number > t):
        count += 1
        if count > maxCount:
            maxCount = count
    else:
        if count > maxCount:
            maxCount = count
        count = 0
    

print(maxCount)


# import java.util.*
# import java.io.*

# fun main() {
#     val sc = Scanner(System.`in`)
#     val input = sc.nextLine().split(" ")
    
#     val n = input[0].toInt()
#     val t = input[1].toInt()
#     val numbers = sc.nextLine().split(" ").map { it.toInt() }

#     var count = 0
#     var max = 0
#     numbers.forEach {
#         if (it > t) {
#             count++
#             if (count > max) max = count
#         } else {
#             if (count > max) max = count
#             count = 0
#         }
#     }

#     println(max)
# }