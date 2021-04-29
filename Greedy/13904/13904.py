n = int(input())
homeworks = []
day = [False for _ in range(1001)]
for _ in range(n):
    d, credit = map(int, input().split())
    homeworks.append((credit, d))
homeworks.sort()
tot = 0
for idx in range(n-1, -1, -1):
    credit, d = homeworks[idx]
    for dd in range(d, 0, -1):
        if not day[dd]:
            tot += credit
            day[dd] = True
            break
print(tot)