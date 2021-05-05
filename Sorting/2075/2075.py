n = int(input())
l = []
for _ in range(n):
    temp = sorted(list(map(int, input().split()))+l, reverse=True)
    l = temp[:n]
print(l[n-1])