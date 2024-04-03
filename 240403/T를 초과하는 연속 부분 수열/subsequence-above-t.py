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