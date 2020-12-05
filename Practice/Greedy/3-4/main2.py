# 1이 될 때까지 99p
n, k = map(int, input().split())
result = 0

while True:
    target = (n // k) * k
    result += (n - target)
    n = target
    if n < k: break
    n //= k
    result += 1

result += (n - 1)
print(result)