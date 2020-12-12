n = input()
fear = list(map(int, input().split()))
fear.sort()

result = 0
count = 0
for f in fear:
    count += 1
    if f <= count:
        result += 1
        count = 0
print(result)