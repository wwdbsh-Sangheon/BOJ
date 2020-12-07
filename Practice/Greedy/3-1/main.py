n = int(input())
count = 0

coins = [500, 100, 50, 10]

for c in coins:
    count += (n // c) # // 몫 구하는 산술 연산자
    n %= c

print(count)
