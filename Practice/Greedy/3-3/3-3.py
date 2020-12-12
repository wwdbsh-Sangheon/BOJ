n, m = map(int, input().split(" "))
result = 0
for i in range(n):
    result = max(min(map(int, input().split(" "))), result)
print(result)