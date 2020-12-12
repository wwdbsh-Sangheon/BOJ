n, m = map(int, input().split())
balls = list(map(int, input().split()))

weight = [0] * 11

for w in balls:
    weight[w] += 1

result = 0

for i in range(1, m+1):
    n -= weight[i]
    result += weight[i]*n

print(result)
