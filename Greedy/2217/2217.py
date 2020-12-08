n = int(input())
rope = []
for i in range(n):
    rope.append(int(input()))

rope.sort()
result = 0
for i in range(n):
    result = max(result, rope[i] * (n-i))   

print(result)